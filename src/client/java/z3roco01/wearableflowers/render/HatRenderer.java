package z3roco01.wearableflowers.render;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import z3roco01.wearableflowers.WearableFlowersClient;

abstract public class HatRenderer implements TrinketRenderer {
    protected final Item item;

    public HatRenderer(Item item) {
        this.item = item;
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> entityModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if(!(entity instanceof ClientPlayerEntity)) return;

        matrices.push();
        TrinketRenderer.followBodyRotations(entity, (PlayerEntityModel)entityModel);
        TrinketRenderer.translateToFace(matrices, (PlayerEntityModel)entityModel, (ClientPlayerEntity)entity, headYaw, headPitch);
        renderHat(stack, slotReference, (PlayerEntityModel<ClientPlayerEntity>) entityModel, matrices, vertexConsumers, light, (ClientPlayerEntity) entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch);
        matrices.pop();
    }

    abstract protected void renderHat(ItemStack stack, SlotReference slotReference, PlayerEntityModel<ClientPlayerEntity> entityModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch);
}
