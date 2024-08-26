package z3roco01.wearableflowers;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.item.Items;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import z3roco01.wearableflowers.render.FlowerRenderer;

public class WearableFlowersClient implements ClientModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger(WearableFlowers.MOD_ID + "_client");

	@Override
	public void onInitializeClient() {
		TrinketRendererRegistry.registerRenderer(Items.ALLIUM,             new FlowerRenderer(Items.ALLIUM));
		TrinketRendererRegistry.registerRenderer(Items.AZURE_BLUET,        new FlowerRenderer(Items.AZURE_BLUET));
		TrinketRendererRegistry.registerRenderer(Items.BLUE_ORCHID,        new FlowerRenderer(Items.BLUE_ORCHID));
		TrinketRendererRegistry.registerRenderer(Items.CORNFLOWER,         new FlowerRenderer(Items.CORNFLOWER));
		TrinketRendererRegistry.registerRenderer(Items.DANDELION,          new FlowerRenderer(Items.DANDELION));
		TrinketRendererRegistry.registerRenderer(Items.LILY_OF_THE_VALLEY, new FlowerRenderer(Items.LILY_OF_THE_VALLEY));
		TrinketRendererRegistry.registerRenderer(Items.OXEYE_DAISY,        new FlowerRenderer(Items.OXEYE_DAISY));
		TrinketRendererRegistry.registerRenderer(Items.POPPY,              new FlowerRenderer(Items.POPPY));
		TrinketRendererRegistry.registerRenderer(Items.TORCHFLOWER,        new FlowerRenderer(Items.TORCHFLOWER));
		TrinketRendererRegistry.registerRenderer(Items.ORANGE_TULIP,       new FlowerRenderer(Items.ORANGE_TULIP));
		TrinketRendererRegistry.registerRenderer(Items.PINK_TULIP,         new FlowerRenderer(Items.PINK_TULIP));
		TrinketRendererRegistry.registerRenderer(Items.RED_TULIP,          new FlowerRenderer(Items.RED_TULIP));
		TrinketRendererRegistry.registerRenderer(Items.WHITE_TULIP,        new FlowerRenderer(Items.WHITE_TULIP));
		TrinketRendererRegistry.registerRenderer(Items.WITHER_ROSE,        new FlowerRenderer(Items.WITHER_ROSE));

		LOGGER.info("client init finished :p");
	}
}