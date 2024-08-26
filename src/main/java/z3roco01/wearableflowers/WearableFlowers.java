package z3roco01.wearableflowers;

import net.fabricmc.api.ModInitializer;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.wearableflowers.item.FlowerItems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WearableFlowers implements ModInitializer {
	public static final String MOD_ID = "wearable_flowers";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
    public static final Map<Item, Item> ITEM_WEARABLE_MAP;

    @Override
	public void onInitialize() {
		FlowerItems.register();

		LOGGER.info("init finished :3 ");
	}

	static {
		Map<Item, Item> map = new HashMap<>();

		map.put(Items.ALLIUM,             FlowerItems.ALLIUM);
		map.put(Items.AZURE_BLUET,        FlowerItems.AZURE_BLUET);
		map.put(Items.BLUE_ORCHID,        FlowerItems.BLUE_ORCHID);
		map.put(Items.CORNFLOWER,         FlowerItems.CORNFLOWER);
		map.put(Items.DANDELION,          FlowerItems.DANDELION);
		map.put(Items.LILY_OF_THE_VALLEY, FlowerItems.LILY_OF_THE_VALLEY);
		map.put(Items.OXEYE_DAISY,        FlowerItems.OXEYE_DAISY);
		map.put(Items.POPPY,              FlowerItems.POPPY);
		map.put(Items.TORCHFLOWER,        FlowerItems.TORCHFLOWER);
		map.put(Items.ORANGE_TULIP,       FlowerItems.ORANGE_TULIP);
		map.put(Items.PINK_TULIP,         FlowerItems.PINK_TULIP);
		map.put(Items.RED_TULIP,          FlowerItems.RED_TULIP);
		map.put(Items.WHITE_TULIP,        FlowerItems.WHITE_TULIP);
		map.put(Items.WITHER_ROSE,        FlowerItems.WITHER_ROSE);

		ITEM_WEARABLE_MAP = Collections.unmodifiableMap(map);
	}
}