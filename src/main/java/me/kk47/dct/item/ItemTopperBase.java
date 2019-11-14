package me.kk47.dct.item;

import java.util.ArrayList;
import java.util.List;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.api.IItemTopper;
import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import me.kk47.ueri.UERIRenderable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;

public class ItemTopperBase extends Item implements IItemTopper {

	private List<UERIRenderable> render;
	
	public ItemTopperBase(String registryName) {
		render = new ArrayList<UERIRenderable>();
		this.setRegistryName(registryName);
		this.setUnlocalizedName(registryName);
		this.setCreativeTab(DChristmasTrees.treeTab);
		this.setMaxStackSize(1);
	}
	
	protected void addRenderable(UERIRenderable renderable) {
		render.add(renderable);
	}

	@Override
	public List<UERIRenderable> getRenderables(TileEntityChristmasTree treetype) {
		return render;
	}

	private static final float INCREMENT = 360/8;
	
	@Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (this.isInCreativeTab(tab)) {
        	for(float i = 0; i < 8.0F; i+=1.0F) {
//        		System.out.println("ItemRotation should be " + INCREMENT*i);
        		items.add(generateItem(INCREMENT*i));
        	}
        }
    }
	
	private ItemStack generateItem(float rotation) {
		ItemStack stack = new ItemStack(this);
		NBTTagCompound compound = new NBTTagCompound();
		compound.setFloat("rotation", rotation);
		stack.setTagCompound(compound);
		return stack;
	}
	
	@Override
	public boolean canBeOnTree(TileEntityChristmasTree treetype) {
		if(treetype instanceof TileEntityChristmasTreeNormal) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public float getRotation(ItemStack item) {
		try {
//			System.out.println("Expecting to return rotation " + item.getTagCompound().getFloat("rotation"));
			return item.getTagCompound().getFloat("rotation");
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static NBTTagCompound getRotationCompound(float rotation) {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setFloat("rotation", rotation);
		return compound;
	}

	@Override
	public Item asItem() {
		return this;
	}
}
