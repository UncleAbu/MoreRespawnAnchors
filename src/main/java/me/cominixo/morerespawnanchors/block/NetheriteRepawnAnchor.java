package me.cominixo.morerespawnanchors.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public class NetheriteRepawnAnchor extends BaseRespawnAnchor {

    public NetheriteRepawnAnchor(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(getCharges(), 0));
    }

    @Override
    public IntProperty getCharges() {
        return IntProperty.of("charges", 0, 12);
    }

    @Override
    public int getMaxCharges() {
        return 12;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(getCharges());
    }




}
