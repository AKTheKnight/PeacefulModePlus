package com.aktheknight.peacefulmodeplus.init;

import com.aktheknight.peacefulmodeplus.blocks.GunpowderOre;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class ModBlocks {
	
	public static Block gunpowderOre;

    public static final void init() {
    	GameRegistry.registerBlock(gunpowderOre = new GunpowderOre(Material.rock, Items.gunpowder), "gunpowderOre");
    }

}
