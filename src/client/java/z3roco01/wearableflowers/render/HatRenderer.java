package z3roco01.wearableflowers.render;


abstract public class HatRenderer{
    /*protected final Item item;

    public HatRenderer(Item item) {
        this.item = item;
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel entityModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if(!(entity instanceof ClientPlayerEntity)) return;

        matrices.push();
        TrinketRenderer.followBodyRotations(entity, (BipedEntityModel)entityModel);
        TrinketRenderer.translateToFace(matrices, (PlayerEntityModel<AbstractClientPlayerEntity>)entityModel, (ClientPlayerEntity)entity, headYaw, headPitch);
        renderHat(stack, slotReference, (PlayerEntityModel) entityModel, matrices, vertexConsumers, light, (ClientPlayerEntity) entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch);
        matrices.pop();
    }

    abstract protected void renderHat(ItemStack stack, SlotReference slotReference, PlayerEntityModel playerModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ClientPlayerEntity player, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch);*/
}
