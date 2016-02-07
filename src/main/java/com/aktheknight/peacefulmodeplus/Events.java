package com.aktheknight.peacefulmodeplus;

import java.util.Random;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.init.Items;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Events {
	
	private Random random = new Random();
	private static int rand;
	
	public static Logger LOGGER = LogManager.getLogger(PeacefulModePlus.MODID);
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent event) {
		LOGGER.log(Level.INFO, "Entity Drop Event");
		rand = random.nextInt(6);
		if(rand != 0) {
			LOGGER.log(Level.INFO, "Dropping " + rand + " bones");
			event.entity.dropItem(Items.bone, rand);
		}
		rand = random.nextInt(6);
		if(rand != 0) {
			LOGGER.log(Level.INFO, "Dropping " + rand + " rotten flesh");
			event.entity.dropItem(Items.rotten_flesh, rand);
		}
	}
}
