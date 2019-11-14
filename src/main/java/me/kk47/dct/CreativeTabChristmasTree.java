package me.kk47.dct;

import me.kk47.dct.block.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class CreativeTabChristmasTree extends CreativeTabs {

	public CreativeTabChristmasTree() {
		super("christmastrees");
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.itemTree);
	}
}
