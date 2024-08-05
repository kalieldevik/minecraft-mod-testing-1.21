package net.kali.mcmodtesting;

import net.fabricmc.api.ModInitializer;

import net.kali.mcmodtesting.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MinecraftModTesting implements ModInitializer {
	public static final String MOD_ID = "mcmodtesting";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModItems.initialize();
	}
}