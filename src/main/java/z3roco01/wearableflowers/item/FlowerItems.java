package z3roco01.wearableflowers.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import z3roco01.wearableflowers.WearableFlowers;

public class FlowerItems {
    public static final Item ALLIUM             = new Item(new Item.Settings());
    public static final Item AZURE_BLUET        = new Item(new Item.Settings());
    public static final Item BLUE_ORCHID        = new Item(new Item.Settings());
    public static final Item CORNFLOWER         = new Item(new Item.Settings());
    public static final Item DANDELION          = new Item(new Item.Settings());
    public static final Item LILY_OF_THE_VALLEY = new Item(new Item.Settings());
    public static final Item OXEYE_DAISY        = new Item(new Item.Settings());
    public static final Item POPPY              = new Item(new Item.Settings());
    public static final Item TORCHFLOWER        = new Item(new Item.Settings());
    public static final Item ORANGE_TULIP       = new Item(new Item.Settings());
    public static final Item PINK_TULIP         = new Item(new Item.Settings());
    public static final Item RED_TULIP          = new Item(new Item.Settings());
    public static final Item WHITE_TULIP        = new Item(new Item.Settings());
    public static final Item WITHER_ROSE       = new Item(new Item.Settings());

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

    private static void register(String id, Item item) {
        Registry.register(Registries.ITEM, Identifier.of(WearableFlowers.MOD_ID, id), item);
    }
}







