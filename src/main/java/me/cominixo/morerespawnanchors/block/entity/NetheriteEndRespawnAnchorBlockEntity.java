package me.cominixo.morerespawnanchors.block.entity;

import me.cominixo.morerespawnanchors.MoreRespawnAnchors;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;

public class NetheriteEndRespawnAnchorBlockEntity extends BaseRespawnAnchorBlockEntity {


    public NetheriteEndRespawnAnchorBlockEntity(BlockPos pos, BlockState state) {
        super(MoreRespawnAnchors.NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY, pos, state);
    }

    public NetheriteEndRespawnAnchorBlockEntity(BlockPos pos, BlockState state, IntProperty charges) {
        super(MoreRespawnAnchors.NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY, pos, state, charges);
    }

}
