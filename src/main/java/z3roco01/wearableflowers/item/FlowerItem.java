package z3roco01.wearableflowers.item;

import io.wispforest.accessories.api.AccessoryItem;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import z3roco01.wearableflowers.WearableFlowers;

public class FlowerItem extends AccessoryItem {
    public final RegistryKey<Item> REGISTRY_KEY;
    public FlowerItem(String id) {
        super(new Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WearableFlowers.MOD_ID, id))));
        this.REGISTRY_KEY = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WearableFlowers.MOD_ID, id));
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference reference) {
        WearableFlowers.LOGGER.info(reference.createSlotPath());
        return true;
    }
}
