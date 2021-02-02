package me.cominixo.morerespawnanchors.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.EndPortalBlockEntity;
import net.minecraft.state.property.IntProperty;

public class BaseRespawnAnchorBlockEntity extends EndPortalBlockEntity {
    public IntProperty charges;

    public BaseRespawnAnchorBlockEntity(BlockEntityType<?> blockEntityType) {
        super(blockEntityType);
    }

    public BaseRespawnAnchorBlockEntity(BlockEntityType<?> blockEntityType, IntProperty charges) {
        super(blockEntityType);
        this.charges = charges;

    }


}
