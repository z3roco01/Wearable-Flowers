package z3roco01.wearableflowers;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.wearableflowers.item.FlowerItems;

public class WearableFlowers implements ModInitializer {
	public static final String MOD_ID = "wearable_flowers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		FlowerItems.register();

		LOGGER.info("init finished :3 ");
	}
}