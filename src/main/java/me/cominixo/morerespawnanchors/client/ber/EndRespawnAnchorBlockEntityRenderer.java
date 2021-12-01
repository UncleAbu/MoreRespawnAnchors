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
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.EndPortalBlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Matrix4f;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class EndRespawnAnchorBlockEntityRenderer<T extends BaseRespawnAnchorBlockEntity> extends EndPortalBlockEntityRenderer<T> {


    public EndRespawnAnchorBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        super(ctx);
    }


    public void render(T endPortalBlockEntity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        if (endPortalBlockEntity.getCachedState().get(endPortalBlockEntity.charges) > 0) {
            Matrix4f matrix4f = matrixStack.peek().getPositionMatrix();
            this.renderSide(endPortalBlockEntity, matrix4f, vertexConsumerProvider.getBuffer(this.getLayer()), 0.1860F, 0.8140F, getTopYOffset(), getTopYOffset(), 0.8140F, 0.8140F, 0.1860F, 0.1860F);
        }

    }

    private void renderSide(T entity, Matrix4f model, VertexConsumer vertices, float x1, float x2, float y1, float y2, float z1, float z2, float z3, float z4) {
        if (entity.shouldDrawSide(Direction.UP)) {
            vertices.vertex(model, x1, y1, z1).next();
            vertices.vertex(model, x2, y1, z2).next();
            vertices.vertex(model, x2, y2, z3).next();
            vertices.vertex(model, x1, y2, z4).next();
        }

    }

    protected float getTopYOffset() {
        return 1.0F;
    }


}
