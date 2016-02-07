package com.aktheknight.peacefulmodeplus;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aktheknight.peacefulmodeplus.init.ModBlocks;
import com.aktheknight.peacefulmodeplus.init.ModWorldGen;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public static Logger LOGGER = LogManager.getLogger(PeacefulModePlus.MODID);
	
	public void preInit(FMLPreInitializationEvent e) {
		
/*		LOGGER.log(Level.INFO, "Starting items init");
		ModItems.init();
		LOGGER.log(Level.INFO, "Finished items init"); */
		LOGGER.log(Level.INFO, "Starting blocks init");
		ModBlocks.init();
		LOGGER.log(Level.INFO, "Finished blocks init");
		LOGGER.log(Level.INFO, "Registering event handler");
		MinecraftForge.EVENT_BUS.register(PeacefulModePlus.handler);
		LOGGER.log(Level.INFO, "Registering event handler done");
/*		LOGGER.log(Level.INFO, "Starting recipes init");
		ModRecipes.init();
		LOGGER.log(Level.INFO, "Finished recipes init"); */
	}
	
	public void init(FMLInitializationEvent e) {
		LOGGER.log(Level.INFO, "Starting WorldGen setup");
		GameRegistry.registerWorldGenerator(new ModWorldGen(), 1);
		LOGGER.log(Level.INFO, "Finished WorldGen setup"); 
	}
	
	public void postInit(FMLPostInitializationEvent e) {
		
	}
}
