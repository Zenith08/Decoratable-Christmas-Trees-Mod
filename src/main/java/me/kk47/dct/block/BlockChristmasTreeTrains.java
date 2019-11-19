package me.kk47.dct.block;

import me.kk47.dct.DChristmasTrees;
import me.kk47.dct.gui.DCTGuiHandling;
import me.kk47.dct.te.TileEntityChristmasTreeTrains;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockChristmasTreeTrains extends BlockChristmasTreeNormal {

	public BlockChristmasTreeTrains() {
		super();
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChristmasTreeTrains();
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if (!worldIn.isRemote) {
	        playerIn.openGui(DChristmasTrees.instance, DCTGuiHandling.CHRISTMAS_TRAINS_GUI, worldIn, pos.getX(), pos.getY(), pos.getZ());
	    }
	    return true;
    }
}
