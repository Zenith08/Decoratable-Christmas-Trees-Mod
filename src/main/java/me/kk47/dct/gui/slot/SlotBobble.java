package me.kk47.dct.gui.slot;

import me.kk47.dct.api.IItemBobble;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotBobble extends Slot {

	public SlotBobble(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}
	
	@Override
	public boolean isItemValid(ItemStack is) {
		if(is.getItem() instanceof IItemBobble) {
			return true;
		} else {
			return false;
		}
	}

}
