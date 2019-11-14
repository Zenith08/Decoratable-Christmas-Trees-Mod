package me.kk47.dct.te;

import java.util.List;

import javax.annotation.Nullable;

import me.kk47.dct.api.IItemDecoration;
import me.kk47.dct.block.ModBlocks;
import me.kk47.ueri.UERIRenderable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;

public abstract class TileEntityChristmasTree extends TileEntity implements IInventory, ITickable {

	private static final String TOPPER_TAG = "topper";
	private static final String DECORATION_TAG_A = "decorationA";
	private static final String DECORATION_TAG_B = "decorationB";
	private static final String LIGHTS_TAG = "lights";

	private NonNullList<ItemStack> inventory;

	public TileEntityChristmasTree() {
		inventory = NonNullList.withSize(getSizeInventory(), ItemStack.EMPTY);
	}

	public abstract boolean supportsTrains();

	/**The Christmas Tree's Model(s)*/
	public abstract List<UERIRenderable> getTreeRenderables();

	@Override
	/**Must be overridden to support train disabling*/
	public abstract int getSizeInventory();

	@Override
	public String getName() {
		return "Christmas Tree";
	}

	@Override
	public boolean hasCustomName() {
		return false;
	}

	@Override
	public boolean isEmpty() {
		for(int i = 0; i < inventory.size(); i++) {
			if(inventory.get(i) != ItemStack.EMPTY)
				return false;
		}
		return true;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		if (index < 0 || index >= this.getSizeInventory())
			return ItemStack.EMPTY;
		return this.inventory.get(index);
	}

	@Override
	public ItemStack decrStackSize(int index, int count) {
		if (this.getStackInSlot(index) != ItemStack.EMPTY) {
			ItemStack itemstack;

			if (this.getStackInSlot(index).getCount() <= count) {
				itemstack = this.getStackInSlot(index);
				this.setInventorySlotContents(index, ItemStack.EMPTY);
				this.markDirty();
				return itemstack;
			} else {
				itemstack = this.getStackInSlot(index).splitStack(count);

				if (this.getStackInSlot(index).getCount() <= 0) {
					this.setInventorySlotContents(index, ItemStack.EMPTY);
				} else {
					//Just to show that changes happened
					this.setInventorySlotContents(index, this.getStackInSlot(index));
				}

				this.markDirty();
				return itemstack;
			}
		} else {
			return ItemStack.EMPTY;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int index) {
		ItemStack stack = this.getStackInSlot(index);
		this.setInventorySlotContents(index, ItemStack.EMPTY);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack stack) {
		if (index < 0 || index >= this.getSizeInventory())
			return;

		if (stack != ItemStack.EMPTY && stack.getCount() > this.getInventoryStackLimit())
			stack.setCount(this.getInventoryStackLimit());

		if (stack != ItemStack.EMPTY && stack.getCount() == 0)
			stack = ItemStack.EMPTY;

		this.inventory.set(index, stack);
		this.markDirty();
	}

	@Override
	public int getInventoryStackLimit() {
		return 1;
	}

	@Override
	public boolean isUsableByPlayer(EntityPlayer player) {
		return this.world.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}

	@Override
	public void openInventory(EntityPlayer player) {} //Not important

	@Override
	public void closeInventory(EntityPlayer player) {} //Not important

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		if(stack.getItem() instanceof IItemDecoration) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void update() {
		this.updateSync();
	}

	//Client Server Synchronization
	//Called on Server side
	@Nullable
	@Override
	public SPacketUpdateTileEntity getUpdatePacket(){
		//		System.out.println("<Server> sending update packet");
		super.getUpdatePacket();
		return new SPacketUpdateTileEntity(this.pos, 0, getUpdateTag());
	}

	//Server
	@Override
	public NBTTagCompound getUpdateTag(){
		//		System.out.println("<Server> get update tag");
		super.getUpdateTag();
		NBTTagCompound syncData = new NBTTagCompound();
		this.writeSyncableDataToNBT(syncData);
		return syncData;
	}

	//Client
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt){
		super.onDataPacket(net, pkt);
		readSyncableDataFromNBT(pkt.getNbtCompound());
	}

	protected void writeSyncableDataToNBT(NBTTagCompound syncData) {
		if(inventory.get(0) != ItemStack.EMPTY) {
			syncData.setTag(TOPPER_TAG, getSyncItemStack(inventory.get(0)));
		}
		if(inventory.get(1) != ItemStack.EMPTY) {
			syncData.setTag(DECORATION_TAG_A, getSyncItemStack(inventory.get(1)));
		}
		if(inventory.get(2) != ItemStack.EMPTY) {
			syncData.setTag(DECORATION_TAG_B, getSyncItemStack(inventory.get(2)));
		}
		if(inventory.get(3) != ItemStack.EMPTY) {
			syncData.setTag(LIGHTS_TAG, getSyncItemStack(inventory.get(3)));
		}
	}

	protected void readSyncableDataFromNBT(NBTTagCompound syncData){
		if(syncData.hasKey(TOPPER_TAG)) {
			inventory.set(0, new ItemStack(syncData.getCompoundTag(TOPPER_TAG)));
		}
		if(syncData.hasKey(DECORATION_TAG_A)) {
			inventory.set(1, new ItemStack(syncData.getCompoundTag(DECORATION_TAG_A))); 
		}
		if(syncData.hasKey(DECORATION_TAG_B)) {
			inventory.set(2, new ItemStack(syncData.getCompoundTag(DECORATION_TAG_B)));
		}
		if(syncData.hasKey(LIGHTS_TAG)) {
			inventory.set(3, new ItemStack(syncData.getCompoundTag(LIGHTS_TAG)));
		}
	}

	protected NBTTagCompound getSyncItemStack(ItemStack is){
		NBTTagCompound stack = new NBTTagCompound();
		stack = is.writeToNBT(stack);
		return stack;
	}

	private int nextSync = 20;

	private void updateSync(){
		nextSync--;
		if(nextSync == 0){
			world.notifyBlockUpdate(pos, ModBlocks.normalTree.getDefaultState(), ModBlocks.normalTree.getDefaultState(), 1);
			markDirty(); // Marks the chunk as dirty, so that it is saved properly on changes. Not required for the sync specifically, but usually goes alongside the former.
			nextSync = 20;
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
		super.writeToNBT(compound);
		writeSyncableDataToNBT(compound);
		return compound;
    }
	
	@Override
	public void readFromNBT(NBTTagCompound compound)
    {
		super.readFromNBT(compound);
		readSyncableDataFromNBT(compound);
    }

	@Override
	public void clear() {
		for (int i = 0; i < this.getSizeInventory(); i++)
			this.setInventorySlotContents(i, ItemStack.EMPTY);
	}

	@Override
	public int getField(int id) { //Useless
		return 0;
	}

	@Override
	public void setField(int id, int value) { //Useless

	}

	@Override
	public int getFieldCount() { //Useless
		return 0;
	}
}
