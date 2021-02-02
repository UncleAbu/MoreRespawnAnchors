package me.cominixo.morerespawnanchors.client.ber;

import com.google.common.collect.ImmutableList;
import me.cominixo.morerespawnanchors.block.EndRespawnAnchor;
import me.cominixo.morerespawnanchors.block.entity.BaseRespawnAnchorBlockEntity;
import me.cominixo.morerespawnanchors.block.entity.EndRespawnAnchorBlockEntity;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class EndRespawnAnchorBlockEntityRenderer<T extends BaseRespawnAnchorBlockEntity> extends EndPortalBlockEntityRenderer<T> {

    private static final Random RANDOM = new Random(31100L);
    private static final List<RenderLayer> field_21732 = IntStream.range(0, 16).mapToObj((i) -> RenderLayer.getEndPortal(i + 1)).collect(ImmutableList.toImmutableList());



    public EndRespawnAnchorBlockEntityRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
    }


    public void render(T endPortalBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        if (endPortalBlockEntity.getCachedState().get(endPortalBlockEntity.charges) > 0) {
            RANDOM.setSeed(31100L);
            double d = endPortalBlockEntity.getPos().getSquaredDistance(this.dispatcher.camera.getPos(), true);
            int k = this.method_3592(d);
            float g = this.method_3594();
            Matrix4f matrix4f = matrixStack.peek().getModel();
            this.method_23084(endPortalBlockEntity, g, 0.15F, matrix4f, vertexConsumerProvider.getBuffer(field_21732.get(0)));

            for(int l = 1; l < k; ++l) {
                this.method_23084(endPortalBlockEntity, g, 2.0F / (float)(18 - l), matrix4f, vertexConsumerProvider.getBuffer(field_21732.get(l)));
            }
        }


    }

    private void method_23084(T endPortalBlockEntity, float f, float g, Matrix4f matrix4f, VertexConsumer vertexConsumer) {
        float h = (RANDOM.nextFloat() * 0.5F + 0.1F) * g;
        float i = (RANDOM.nextFloat() * 0.5F + 0.4F) * g;
        float j = (RANDOM.nextFloat() * 0.5F + 0.5F) * g;
        this.method_23085(endPortalBlockEntity, matrix4f, vertexConsumer, f, f, h, i, j);
    }

    private void method_23085(T endPortalBlockEntity, Matrix4f matrix4f, VertexConsumer vertexConsumer, float h, float i, float n, float o, float p) {
        if (endPortalBlockEntity.shouldDrawSide(Direction.UP)) {
            vertexConsumer.vertex(matrix4f, (float) 0.1860, h, (float) 0.8140).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, (float) 0.8140, h, (float) 0.8140).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, (float) 0.8140, i, (float) 0.1860).color(n, o, p, 1.0F).next();
            vertexConsumer.vertex(matrix4f, (float) 0.1860, i, (float) 0.1860).color(n, o, p, 1.0F).next();
        }

    }

    protected int method_3592(double d) {
        return super.method_3592(d * 3.0D) + 1;
    }

    protected float method_3594() {
        return 1.0F;
    }


}
