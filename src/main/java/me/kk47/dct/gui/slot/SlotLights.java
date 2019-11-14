package me.kk47.dct.gui.slot;

import me.kk47.dct.api.IItemLights;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotLights extends Slot {

	public SlotLights(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		super(inventoryIn, index, xPosition, yPosition);
	}

	@Override
	public boolean isItemValid(ItemStack is) {
		if(is.getItem() instanceof IItemLights) {
			return true;
		} else {
			return false;
		}
	}
}
