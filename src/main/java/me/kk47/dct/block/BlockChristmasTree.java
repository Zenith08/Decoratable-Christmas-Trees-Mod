package me.kk47.dct.block;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.gui.DCTGuiHandling;
import me.kk47.dct.te.TileEntityChristmasTree;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockChristmasTree extends Block implements ITileEntityProvider{

	public static final String name = "christmastree";
	
	public BlockChristmasTree(String nameExtension) {
		super(Material.WOOD);
		
		this.setUnlocalizedName(name + "-" + nameExtension);
		this.setRegistryName(name + "-" + nameExtension);
		
		this.setLightLevel(15.0F);
		this.setLightOpacity(0);
		this.setHardness(2.0F);
		this.setResistance(3F);
		
		this.setCreativeTab(DChristmasTrees.treeTab);
	}

/*	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChristmasTree();
	}*/
	
	/**
     * The type of render function called. MODEL for mixed tesr and static model, MODELBLOCK_ANIMATED for TESR-only,
     * LIQUID for vanilla liquids, INVISIBLE to skip all rendering
     */
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.ENTITYBLOCK_ANIMATED;
    }

	@SideOnly(Side.CLIENT)
	@Override
	public BlockRenderLayer getBlockLayer(){
		return BlockRenderLayer.CUTOUT;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState ibs){
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if (!worldIn.isRemote) {
	        playerIn.openGui(DChristmasTrees.instance, DCTGuiHandling.CHRISTMAS_TREE_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
	    }
	    return true;
    }
	
	@Override
	public boolean isFullCube(IBlockState state) {
        return false;
    }
	
	/**
     * Called serverside after this block is replaced with another in Chunk, but before the Tile Entity is updated
     */
	@Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof TileEntityChristmasTree)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityChristmasTree)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        super.breakBlock(worldIn, pos, state);
    }
}
