package me.cominixo.morerespawnanchors.block;


import me.cominixo.morerespawnanchors.block.entity.NetheriteEndRespawnAnchorBlockEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class NetheriteEndRespawnAnchor extends BaseRespawnAnchor implements BlockEntityProvider {

    public NetheriteEndRespawnAnchor(Settings settings) {
        super(settings);
        setDefaultState(this.getDefaultState().with(getCharges(), 0));
    }

    @Override
    protected boolean isChargeItem(ItemStack stack) {
        return stack.getItem() == Items.ENDER_PEARL;
    }

    @Override
    public boolean isDimension(World world) {
        return world.getRegistryKey().equals(World.END);
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

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockView world) {
        return new NetheriteEndRespawnAnchorBlockEntity(getCharges());
    }


}
