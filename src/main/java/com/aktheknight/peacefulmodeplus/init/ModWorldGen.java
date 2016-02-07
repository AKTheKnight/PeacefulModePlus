package com.aktheknight.peacefulmodeplus.init;

import java.util.Random;

import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class ModWorldGen implements IWorldGenerator {
	
	private WorldGenerator gen_shrink_ore; //Generates Tutorial Ore (used in Overworld)

	public ModWorldGen() {
	    this.gen_shrink_ore = new WorldGenMinable(ModBlocks.gunpowderOre.getDefaultState(), 6);
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {   
		switch (world.provider.getDimensionId()) {
	    case 0: //Overworld
	    	this.runGenerator(this.gen_shrink_ore, world, random, chunkX, chunkZ, 5, 0, 30);
	        break;
	    case -1: //Nether
	    	
	        break;
	    case 1: //End
	    	
	        break;
	    }
	}
	
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) {
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator");

	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
}
