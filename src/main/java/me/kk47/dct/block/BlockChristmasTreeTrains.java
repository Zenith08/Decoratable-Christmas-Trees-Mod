package me.kk47.dct.block;

import me.kk47.dct.te.TileEntityChristmasTreeNormal;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockChristmasTreeTrains extends BlockChristmasTreeNormal {

	public BlockChristmasTreeTrains() {
		super("n-trains");
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityChristmasTreeNormal();
	}

}
