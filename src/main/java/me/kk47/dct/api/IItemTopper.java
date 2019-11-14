package me.kk47.dct.api;

import net.minecraft.item.ItemStack;

public interface IItemTopper extends IItemDecoration {

	float getRotation(ItemStack item);
	
}
