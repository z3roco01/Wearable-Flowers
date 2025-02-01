package z3roco01.wearableflowers.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import z3roco01.wearableflowers.WearableFlowers;

public class FlowerItems {
    public static final FlowerItem ALLIUM             = new FlowerItem("allium");
    public static final FlowerItem AZURE_BLUET        = new FlowerItem("azure_bluet");
    public static final FlowerItem BLUE_ORCHID        = new FlowerItem("blue_orchid");
    public static final FlowerItem CORNFLOWER         = new FlowerItem("cornflower");
    public static final FlowerItem DANDELION          = new FlowerItem("dandelion");
    public static final FlowerItem LILY_OF_THE_VALLEY = new FlowerItem("lily_of_the_valley");
    public static final FlowerItem OXEYE_DAISY        = new FlowerItem("oxeye_daisy");
    public static final FlowerItem POPPY              = new FlowerItem("poppy");
    public static final FlowerItem TORCHFLOWER        = new FlowerItem("torchflower");
    public static final FlowerItem ORANGE_TULIP       = new FlowerItem("orange_tulip");
    public static final FlowerItem PINK_TULIP         = new FlowerItem("pink_tulip");
    public static final FlowerItem RED_TULIP          = new FlowerItem("red_tulip");
    public static final FlowerItem WHITE_TULIP        = new FlowerItem("white_tulip");
    public static final FlowerItem WITHER_ROSE        = new FlowerItem("wither_rose");

    public static void register() {
        register("allium", ALLIUM);
        register("azure_bluet", AZURE_BLUET);
        register("blue_orchid", BLUE_ORCHID);
        register("cornflower", CORNFLOWER);
        register("dandelion", DANDELION);
        register("lily_of_the_valley", LILY_OF_THE_VALLEY);
        register("oxeye_daisy", OXEYE_DAISY);
        register("poppy", POPPY);
        register("torchflower", TORCHFLOWER);
        register("orange_tulip", ORANGE_TULIP);
        register("pink_tulip", PINK_TULIP);
        register("red_tulip", RED_TULIP);
        register("white_tulip", WHITE_TULIP);
        register("wither_rose", WITHER_ROSE);
    }

    private static void register(String id, FlowerItem item) {
        Registry.register(Registries.ITEM, item.REGISTRY_KEY, (Item)item);
    }
}







