package z3roco01.wearableflowers.mixin;

import dev.emi.trinkets.TrinketsMain;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketInventory;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import z3roco01.wearableflowers.WearableFlowers;

import java.util.Optional;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Shadow public abstract Iterable<ItemStack> getHandItems();

    @Inject(method = "interact", at = @At("HEAD"), cancellable = true)
    private void interact(Entity entity, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        if(!(entity instanceof ServerPlayerEntity)) return;
        ItemStack handStack = ((ServerPlayerEntity)(Object)this).getStackInHand(hand);

        if(!WearableFlowers.ITEM_WEARABLE_MAP.containsKey(handStack.getItem())) return;

        Optional<TrinketComponent> optional = TrinketsApi.getTrinketComponent((ServerPlayerEntity)entity);
        if(optional.isEmpty()) return;

        TrinketComponent trinketComponent = optional.get();
        WearableFlowers.LOGGER.info(trinketComponent.getInventory().get("head").get("hat").getStack(0).toString());
        for(Pair<SlotReference, ItemStack> pair : trinketComponent.getAllEquipped()) {
            SlotReference slotReference = pair.getLeft();
            if(slotReference.inventory().getSlotType().getName().equals("hat")) return;
        }
        trinketComponent.getInventory().get("head").get("hat").setStack(0, new ItemStack(handStack.getItem()));
        handStack.decrement(1);
    }
}
