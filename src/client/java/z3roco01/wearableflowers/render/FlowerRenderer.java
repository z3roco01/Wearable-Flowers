package z3roco01.wearableflowers.render;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import z3roco01.wearableflowers.WearableFlowers;
import z3roco01.wearableflowers.item.FlowerItems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FlowerRenderer extends HatRenderer{
    private final ItemStack WORN_ITEM_STACK;

    public FlowerRenderer(Item item) {
        super(item);
        this.WORN_ITEM_STACK = new ItemStack(WearableFlowers.ITEM_WEARABLE_MAP.get(item));
    }

    @Override
    protected void renderHat(ItemStack stack, SlotReference slotReference, PlayerEntityModel<ClientPlayerEntity> playerModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ClientPlayerEntity player, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180f));
        matrices.translate(0.5875f, 0.5f, 0.525f);

        if(player.getInventory().armor.getLast() != ItemStack.EMPTY) matrices.translate(0.0615f, 0.05f, -0.0615f);

        itemRenderer.renderItem(WORN_ITEM_STACK, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, player.getWorld(), 0);
    }

}
