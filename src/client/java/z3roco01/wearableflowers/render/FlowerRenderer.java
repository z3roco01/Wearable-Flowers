package z3roco01.wearableflowers.render;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
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
    private static final Map<Item, Item> ITEM_WEARABLE_MAP;
    private final ItemStack WORN_ITEM_STACK;

    public FlowerRenderer(Item item) {
        super(item);
        this.WORN_ITEM_STACK = new ItemStack(ITEM_WEARABLE_MAP.get(item));
    }

    @Override
    protected void renderHat(ItemStack stack, SlotReference slotReference, PlayerEntityModel<ClientPlayerEntity> entityModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, ClientPlayerEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180f));
        matrices.translate(0.5875f, 0.5f, 0.525f);
        itemRenderer.renderItem(WORN_ITEM_STACK, ModelTransformationMode.FIXED, light, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 0);
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
