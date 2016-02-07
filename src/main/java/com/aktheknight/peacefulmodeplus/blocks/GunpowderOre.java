package com.aktheknight.peacefulmodeplus.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class GunpowderOre extends Block {
	
	public String unlocalizedName = "gunpowderOre";
	
	private Item drop;
	private int meta;
	
	private int least = 2;
	private int most = 4;
	
	public GunpowderOre(Material mat, Item drop, int meta) {
		super(mat);
		this.drop = drop;
		this.meta = meta;
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(4);
		this.setHarvestLevel("pickaxe", 2);
		this.setUnlocalizedName(unlocalizedName);
	}
	
	public GunpowderOre(Material mat, Item drop) {
		this(mat, drop, 0);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune) {
		return this.drop;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return meta;
	}
	
	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
	    return this.least + random.nextInt(this.most - this.least + fortune + 1);
	}

}
