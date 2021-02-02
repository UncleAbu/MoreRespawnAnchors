package me.cominixo.morerespawnanchors.block.entity;

import me.cominixo.morerespawnanchors.MoreRespawnAnchors;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.state.property.IntProperty;

public class NetheriteEndRespawnAnchorBlockEntity extends BaseRespawnAnchorBlockEntity {


    public NetheriteEndRespawnAnchorBlockEntity() {
        super(MoreRespawnAnchors.NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY);
    }

    public NetheriteEndRespawnAnchorBlockEntity(IntProperty charges) {
        super(MoreRespawnAnchors.NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY, charges);
    }

}
