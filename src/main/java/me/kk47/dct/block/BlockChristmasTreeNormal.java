package me.kk47.dct.block;

import java.util.Random;

import me.kk47.dct.ChristmasDecorationRegistry;
import me.kk47.dct.item.ItemTopperBase;
import me.kk47.dct.te.TileEntityChristmasTree;
import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChristmasTreeNormal extends BlockChristmasTree {

	public BlockChristmasTreeNormal() {
		super("normal");
	}
	
	public BlockChristmasTreeNormal(String name) {
		super(name);
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChristmasTreeNormal();
	}
	
	public static final void placeTreeAt(World world, BlockPos bp){
		Random random = new Random();
		boolean success = world.setBlockState(bp, ModBlocks.normalTree.getDefaultState(), 2);
		//		System.out.println("Block Placing returned " + success);
		if(world.getTileEntity(bp) == null){
			world.setTileEntity(bp, ModBlocks.normalTree.createNewTileEntity(world, 0));
		}
		TileEntityChristmasTree tect = (TileEntityChristmasTree) world.getTileEntity(bp);
		checkTopper(tect, random);
		checkDecorations(tect, random);
		checkLights(tect, random);
	}
	
	private static void checkDecorations(TileEntityChristmasTree tect, Random random) {
		if(random.nextInt(2) == 0){
			tect.setInventorySlotContents(1, new ItemStack(ChristmasDecorationRegistry.getBobbles().get(random.nextInt(ChristmasDecorationRegistry.getBobbles().size())).asItem()));
		}
	}

	private static void checkLights(TileEntityChristmasTree tect, Random random) {
		if(random.nextInt(2) == 0){
			tect.setInventorySlotContents(3, new ItemStack(ChristmasDecorationRegistry.getLights().get(random.nextInt(ChristmasDecorationRegistry.getLights().size())).asItem()));
		}
	}

	private static void checkTopper(TileEntityChristmasTree tect, Random random) {
		if(random.nextInt(3) == 0){
			ItemStack item = new ItemStack(ChristmasDecorationRegistry.getToppers().get(random.nextInt(ChristmasDecorationRegistry.getToppers().size())).asItem());
			item.setTagCompound(ItemTopperBase.getRotationCompound(0.0F));
			tect.setInventorySlotContents(0, item);
		}
	}
}
