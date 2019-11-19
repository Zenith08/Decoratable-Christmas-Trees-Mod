package me.kk47.dct.gui;

import me.kk47.dct.api.IItemDecoration;
import me.kk47.dct.api.IItemLights;
import me.kk47.dct.api.IItemTopper;
import me.kk47.dct.gui.slot.SlotBobble;
import me.kk47.dct.gui.slot.SlotLights;
import me.kk47.dct.gui.slot.SlotTopper;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import me.kk47.modeltrains.gui.slot.SlotTrain;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChristmasTreeTrains extends Container {
	private TileEntityChristmasTreeTrains te;
	private IInventory playerInv;
	
	public ContainerChristmasTreeTrains(IInventory playerInv, TileEntityChristmasTreeTrains te) {
		this.te = te;
		this.playerInv = playerInv;
		
		registerInventorySlots();
	}

	private void registerInventorySlots() {
		//Topper Slot 0, 80, 52
		this.addSlotToContainer(new SlotTopper(te, 0, 116, 20));
		//Bobble A Slot 1
		this.addSlotToContainer(new SlotBobble(te, 1, 116, 38));
		//Bobble B Slot 2
		this.addSlotToContainer(new SlotBobble(te, 2, 134, 38));
		//Christmas Lights, Slot 3
		this.addSlotToContainer(new SlotLights(te, 3, 134, 20));
		
		/*Train slots*/
		this.addSlotToContainer(new SlotTrain(te, 4, 24, 72));
		this.addSlotToContainer(new SlotTrain(te, 5, 42, 72));
		this.addSlotToContainer(new SlotTrain(te, 6, 60, 72));
		this.addSlotToContainer(new SlotTrain(te, 7, 78, 72));
		
		/*The slot for the train set*/
		this.addSlotToContainer(new Slot(te, 8, 6, 72));
		
		// Player Inventory, Slot 9-35, Slot IDs 4-30
	    for (int y = 0; y < 3; y++) {
	        for (int x = 0; x < 9; x++) {
	            this.addSlotToContainer(new Slot(playerInv, x + y * 9 + 9, 8 + x * 18, 104 + y * 18));
	        }
	    }

	    // Player Inventory, Slot 0-8, Slot IDs 36-44
	    for (int x = 0; x < 9; ++x) {
	        this.addSlotToContainer(new Slot(playerInv, x, 8 + x * 18, 162));
	    }
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = ItemStack.EMPTY;
		Slot slot = (Slot) this.inventorySlots.get(fromSlot);

		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();
			if(fromSlot < 4){
				// From TE Inventory to Player Inventory
	            if (!this.mergeItemStack(current, 9, 40, true))
	                return ItemStack.EMPTY;
			}else if(current.getItem() instanceof IItemLights && !this.getSlot(3).getHasStack()){
				this.putStackInSlot(3, new ItemStack(current.getItem(), 1));
				this.getSlot(fromSlot).decrStackSize(1);
			}else if(current.getItem() instanceof IItemTopper && !this.getSlot(0).getHasStack()){
				this.putStackInSlot(0, new ItemStack(current.getItem(), 1));
				this.getSlot(fromSlot).decrStackSize(1);
			}else if(current.getItem() instanceof IItemDecoration){
				if(!this.getSlot(1).getHasStack()){
					this.putStackInSlot(1, new ItemStack(current.getItem(), 1));
					this.getSlot(fromSlot).decrStackSize(1);
				}else if(!this.getSlot(2).getHasStack()){
					this.putStackInSlot(2, new ItemStack(current.getItem(), 1));
					this.getSlot(fromSlot).decrStackSize(1);
				}
			}

			if(current.getCount() == 0) {
				slot.putStack(ItemStack.EMPTY);
			} else {
				slot.onSlotChanged();
			}
			
			if(current.getCount() == previous.getCount()) {
				return ItemStack.EMPTY;
			}
			
			slot.onTake(playerIn, current);
		}
		return previous;
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return this.te.isUsableByPlayer(player);
	}
}
