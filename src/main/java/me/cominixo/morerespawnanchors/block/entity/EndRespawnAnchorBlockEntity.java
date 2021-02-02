package me.cominixo.morerespawnanchors.block.entity;

import me.cominixo.morerespawnanchors.MoreRespawnAnchors;
import net.minecraft.state.property.IntProperty;

public class EndRespawnAnchorBlockEntity extends BaseRespawnAnchorBlockEntity {


    public EndRespawnAnchorBlockEntity() {
        super(MoreRespawnAnchors.END_RESPAWN_ANCHOR_BLOCK_ENTITY);
    }

    public EndRespawnAnchorBlockEntity(IntProperty charges) {
        super(MoreRespawnAnchors.END_RESPAWN_ANCHOR_BLOCK_ENTITY, charges);
    }

}
