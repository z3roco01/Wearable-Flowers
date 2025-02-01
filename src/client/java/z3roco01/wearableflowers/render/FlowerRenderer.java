package z3roco01.wearableflowers.render;


import com.mojang.logging.LogUtils;
import io.wispforest.accessories.Accessories;
import io.wispforest.accessories.api.client.AccessoryRenderer;
import io.wispforest.accessories.api.client.DefaultAccessoryRenderer;
import io.wispforest.accessories.api.client.Side;
import io.wispforest.accessories.api.client.TransformOps;
import io.wispforest.accessories.api.components.AccessoriesDataComponents;
import io.wispforest.accessories.api.components.AccessoryRenderTransformations;
import io.wispforest.accessories.api.slot.SlotReference;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.Arm;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import org.slf4j.Logger;
import z3roco01.wearableflowers.WearableFlowers;
import z3roco01.wearableflowers.mixin.PlayerEntityMixin;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class FlowerRenderer implements AccessoryRenderer{
    /*private final ItemStack WORN_ITEM_STACK;

    public FlowerRenderer(Item item) {
        super(item);
        this.WORN_ITEM_STACK = new ItemStack(WearableFlowers.ITEM_WEARABLE_MAP.get(item));
    }

    @Override
    protected void renderHat(ItemStack stack, SlotReference slotReference, PlayerEntityModel playerModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ClientPlayerEntity player, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180f));
        matrices.translate(0.5875f, 0.5f, 0.525f);

        if(player.getInventory().armor.getLast() != ItemStack.EMPTY) matrices.translate(0.0615f, 0.05f, -0.0615f);

        itemRenderer.renderItem(WORN_ITEM_STACK, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, player.getWorld(), 0);
    }*/

    //--

    public static final FlowerRenderer INSTANCE;


    public FlowerRenderer(){
    }

    public static void registerHelper(String slotType, DefaultAccessoryRenderer.RenderHelper helper){

    }

    @Override
    public <S extends LivingEntityRenderState> void render(ItemStack stack, SlotReference reference, MatrixStack matrices, EntityModel<S> model, S renderState, VertexConsumerProvider multiBufferSource, int light, float partialTicks) {
        if(!(model instanceof BipedEntityModel)) return;
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        AccessoryRenderer.transformToFace(matrices, ((BipedEntityModel) model).head, Side.FRONT);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180f));
        //matrices.translate(0.5875f, 0.5f, 0.525f);

        LivingEntity entity = reference.entity();

        //matrices.multiply(((BipedEntityModel)model).getHead().);
        if(entity instanceof PlayerEntity && ((PlayerEntity)entity).getInventory().armor.getLast() != ItemStack.EMPTY)
            matrices.translate(0.0615f, 0.05f, -0.0615f);

        ItemStack renderStack = new ItemStack(WearableFlowers.ITEM_WEARABLE_MAP.get(stack.getItem()), 1);
        renderStack.set(DataComponentTypes.ITEM_MODEL, Identifier.of("wearable_flowers", "poppy"));
        itemRenderer.renderItem(renderStack, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV,
                matrices, multiBufferSource, entity.getWorld(), 0);



        /*ItemStack wornStack = new ItemStack(WearableFlowers.ITEM_WEARABLE_MAP.get(stack.getItem()), 1);
        if (!(model instanceof BipedEntityModel<? extends BipedEntityRenderState> humanoidModel)) return;

        var disabledTargetType = Accessories.config().clientOptions.disabledDefaultRenders();

        for (var target : disabledTargetType) {
            if(reference.slotName().equals(target.slotType) && target.targetType.isValid(wornStack.getItem())) return;
        }

        Consumer<MatrixStack> render = (poseStack) -> MinecraftClient.getInstance().getItemRenderer().renderItem(wornStack, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, poseStack, multiBufferSource, reference.entity().getWorld(), 0);

        var translationData = wornStack.getOrDefault(AccessoriesDataComponents.RENDER_TRANSFORMATIONS, AccessoryRenderTransformations.EMPTY);

        Consumer<MatrixStack> translationAndRender = poseStack -> {
            TransformOps.transformStack(translationData.transformations(), poseStack, humanoidModel, () -> {
                render.accept(poseStack);
            });
        };

        if(!translationData.disableDefaultTranslations()) {
            var helper = new DefaultAccessoryRenderer.RenderHelper() {
                    @Override
                    public <S extends LivingEntityRenderState> void render(Consumer<MatrixStack> renderCall, MatrixStack matrices, BipedEntityModel<? extends BipedEntityRenderState> humanoidModel, S renderState, SlotReference reference) {
                        AccessoryRenderer.transformToFace(matrices, humanoidModel.head, Side.TOP);
                        matrices.translate(0, 0.25, 0);
                        for (int i = 0; i < reference.getStack().getCount(); i++) {
                            renderCall.accept(matrices);
                            matrices.translate(0, 0.5, 0);
                        }
                    }};
        } else {
            translationAndRender.accept(matrices);
        }*/
    }

    @Override
    public boolean shouldRenderInFirstPerson(Arm arm, ItemStack stack, SlotReference reference) {
        var slotName = reference.slotName();

        return (slotName.equals("hand") || slotName.equals("wrist") || slotName.equals("ring")) && (reference.slot() % 2 == 0 ? arm == Arm.RIGHT : arm == Arm.LEFT);
    }

    public interface RenderHelper {
        <S extends LivingEntityRenderState> void render(Consumer<MatrixStack> renderCall, MatrixStack matrices, BipedEntityModel<? extends BipedEntityRenderState> humanoidModel, S renderState, SlotReference reference);
    }

    static {
        INSTANCE = new FlowerRenderer();
    }
}