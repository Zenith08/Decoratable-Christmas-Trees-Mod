package me.kk47.dct.worldgen;

import java.util.Random;

import me.kk47.dct.block.BlockChristmasTreeNormal;
import net.minecraft.init.Biomes;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class CTWorldGeneration implements IWorldGenerator{

	public CTWorldGeneration() {
		
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.getDimension())
		{
		case -1:
			generateNether(world, random, new BlockPos(chunkX*16, 10, chunkZ*16));
			return;
		case 0:
			generateSurface(world, random, new BlockPos(chunkX*16, 10, chunkZ*16));
			return;
		case 1:
			generateEnd(world, random, new BlockPos(chunkX*16, 10, chunkZ*16));
			return;
		default:
			return;
		}
	}

	private void generateEnd(World world, Random random, BlockPos blockPos) {}

	private void generateSurface(World world, Random random, BlockPos bp) {
		if(world.getBiome(bp) == Biomes.EXTREME_HILLS || world.getBiome(bp) == Biomes.MUTATED_EXTREME_HILLS || 
				world.getBiome(bp) == Biomes.FOREST || world.getBiome(bp) == Biomes.FOREST_HILLS ||
				world.getBiome(bp) == Biomes.BIRCH_FOREST || world.getBiome(bp) == Biomes.BIRCH_FOREST_HILLS ||
				world.getBiome(bp) == Biomes.COLD_TAIGA || world.getBiome(bp) == Biomes.COLD_TAIGA_HILLS ||
				world.getBiome(bp) == Biomes.TAIGA || world.getBiome(bp) == Biomes.TAIGA_HILLS){
			
			//Then we generate a tree
			int randPosX=bp.getX() + random.nextInt(16);
			int randPosZ=bp.getZ() + random.nextInt(16);
			BlockPos testPos=world.getHeight(new BlockPos(randPosX, 0, randPosZ));

			if(world.getBlockState(testPos.down()).getBlock().getUnlocalizedName().equalsIgnoreCase(Blocks.DIRT.getUnlocalizedName())
					|| world.getBlockState(testPos.down()).getBlock().getUnlocalizedName().equalsIgnoreCase(Blocks.GRASS.getUnlocalizedName())){
//			System.out.println("Valid Block");
			}else{
//			System.out.println("looping for Valid Block");
			boolean brk=true;
			while(brk){
				testPos = testPos.down();
				if(world.getBlockState(testPos.down()).getBlock().getUnlocalizedName().equalsIgnoreCase(Blocks.DIRT.getUnlocalizedName())
						|| world.getBlockState(testPos.down()).getBlock().getUnlocalizedName().equalsIgnoreCase(Blocks.GRASS.getUnlocalizedName())){
					brk=false;
				}
				if(testPos.getY() == 0){
					brk=false;
				}
			}
		
			}
			
//			System.out.println("Checking for air");
			if(world.isAirBlock(testPos) && world.isAirBlock(testPos.up())){
				BlockChristmasTreeNormal.placeTreeAt(world, testPos);
//				System.out.println("Placing Block at " + testPos);
			}
		}
	}

	private void generateNether(World world, Random random, BlockPos blockPos) {}

}
