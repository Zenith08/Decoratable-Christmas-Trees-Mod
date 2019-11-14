package me.kk47.dct.gui;

import me.kk47.dct.gui.slot.SlotBobble;
import me.kk47.dct.gui.slot.SlotLights;
import me.kk47.dct.gui.slot.SlotTopper;
import me.kk47.dct.te.TileEntityChristmasTree;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerChristmasTree extends Container {

	private TileEntityChristmasTree te;
	private boolean inTrainMode;

	public ContainerChristmasTree(IInventory playerInv, TileEntityChristmasTree te) {
		this.te = te;
		inTrainMode = te.supportsTrains();
		//TODO Switch based on trains and add slots.
		if(inTrainMode) {
			
		} else {
			this.addSlotToContainer(new SlotTopper(te, 0, 80, 52));	
			this.addSlotToContainer(new SlotBobble(te, 1, 70, 70));
			this.addSlotToContainer(new SlotBobble(te, 2, 89, 70));
			this.addSlotToContainer(new SlotLights(te, 3, 80, 88));
			
			// Player Inventory, Slot 9-35, Slot IDs 4-30
			for (int y = 0; y < 3; ++y) {
				for (int x = 0; x < 9; ++x) {
					this.addSlotToContainer(new Slot(playerInv, y*9+x+9, 8+x*18, 139+y*18));
				}
			}

			// Player Inventory, Slot 0-8, Slot IDs 31-39
			for (int x = 0; x < 9; ++x) {
				this.addSlotToContainer(new Slot(playerInv, x, 8+x*18, 197));
			}
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		return te.isUsableByPlayer(playerIn);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer playerIn, int fromSlot) {
		ItemStack previous = ItemStack.EMPTY;
		Slot slot = this.inventorySlots.get(fromSlot);
		if (slot != null && slot.getHasStack()) {
			ItemStack current = slot.getStack();
			previous = current.copy();
			// [...] Custom behaviour

			//End Custom Behaviour
			if (current.getCount() == 0)
				slot.putStack(ItemStack.EMPTY);
			else
				slot.onSlotChanged();

			if (current.getCount() == previous.getCount())
				return ItemStack.EMPTY;
			slot.onTake(playerIn, current);
		}
		return previous;
	}

	@Override
	protected boolean mergeItemStack(ItemStack stack, int startIndex, int endIndex, boolean useEndIndex) {
		boolean success = false;
		int index = startIndex;

		if (useEndIndex)
			index = endIndex - 1;

		Slot slot;
		ItemStack stackinslot;

		if (stack.isStackable()) {
			while (stack.getCount() > 0 && (!useEndIndex && index < endIndex || useEndIndex && index >= startIndex)) {
				slot = (Slot) this.inventorySlots.get(index);
				stackinslot = slot.getStack();

				if (stackinslot != null && stackinslot.getItem() == stack.getItem() && (!stack.getHasSubtypes() || stack.getMetadata() == stackinslot.getMetadata()) && ItemStack.areItemStackTagsEqual(stack, stackinslot)) {
					int l = stackinslot.getCount() + stack.getCount();
					int maxsize = Math.min(stack.getMaxStackSize(), slot.getItemStackLimit(stack));

					if (l <= maxsize) {
						stack.setCount(0);
						stackinslot.setCount(1);
						slot.onSlotChanged();
						success = true;
					} else if (stackinslot.getCount() < maxsize) {
						//	                    stack.stackSize -= stack.getMaxStackSize() - stackinslot.stackSize;
						stack.setCount(stack.getCount()-stack.getMaxStackSize() - stackinslot.getCount());
						//	                    stackinslot.stackSize = stack.getMaxStackSize();
						stackinslot.setCount(stack.getMaxStackSize());
						slot.onSlotChanged();
						success = true;
					}
				}

				if (useEndIndex) {
					--index;
				} else {
					++index;
				}
			}
		}

		if (stack.getCount() > 0) {
			if (useEndIndex) {
				index = endIndex - 1;
			} else {
				index = startIndex;
			}

			while (!useEndIndex && index < endIndex || useEndIndex && index >= startIndex && stack.getCount() > 0) {
				slot = (Slot) this.inventorySlots.get(index);
				stackinslot = slot.getStack();

				// Forge: Make sure to respect isItemValid in the slot.
				if (stackinslot == null && slot.isItemValid(stack)) {
					if (stack.getCount() < slot.getItemStackLimit(stack)) {
						slot.putStack(stack.copy());
						//	                    stack.stackSize = 0;
						stack.setCount(0);
						success = true;
						break;
					} else {
						ItemStack newstack = stack.copy();
						//	                    newstack.stackSize = slot.getItemStackLimit(stack);
						newstack.setCount(slot.getItemStackLimit(stack));
						slot.putStack(newstack);
						//	                    stack.stackSize -= slot.getItemStackLimit(stack);
						stack.setCount(stack.getCount()-slot.getItemStackLimit(stack));
						success = true;
					}
				}

				if (useEndIndex) {
					--index;
				} else {
					++index;
				}
			}
		}

		return success;
	}
}
