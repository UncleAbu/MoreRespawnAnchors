package me.cominixo.morerespawnanchors;

import me.cominixo.morerespawnanchors.block.BaseRespawnAnchor;
import me.cominixo.morerespawnanchors.block.EndRespawnAnchor;
import me.cominixo.morerespawnanchors.block.NetheriteEndRespawnAnchor;
import me.cominixo.morerespawnanchors.block.NetheriteRepawnAnchor;
import me.cominixo.morerespawnanchors.block.entity.EndRespawnAnchorBlockEntity;
import me.cominixo.morerespawnanchors.block.entity.NetheriteEndRespawnAnchorBlockEntity;
import net.fabricmc.api.ModInitializer;
//import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
//import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.DispenserBlock;
import net.minecraft.block.Material;
import net.minecraft.block.dispenser.FallibleItemDispenserBehavior;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.*;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPointer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
//import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class MoreRespawnAnchors implements ModInitializer {

    public static final NetheriteRepawnAnchor NETHERITE_RESPAWN_ANCHOR = new NetheriteRepawnAnchor(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)
            .luminance(BaseRespawnAnchor::getLightLevelFromState));

    public static final EndRespawnAnchor END_RESPAWN_ANCHOR = new EndRespawnAnchor(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)
            .luminance(BaseRespawnAnchor::getLightLevelFromState));

    public static final NetheriteEndRespawnAnchor NETHERITE_END_RESPAWN_ANCHOR = new NetheriteEndRespawnAnchor(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)
            .luminance(BaseRespawnAnchor::getLightLevelFromState));

    public static BlockEntityType<EndRespawnAnchorBlockEntity> END_RESPAWN_ANCHOR_BLOCK_ENTITY;
    public static BlockEntityType<NetheriteEndRespawnAnchorBlockEntity> NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY;

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.create(new Identifier("morerespawnanchors","general")).icon(()-> new ItemStack(NETHERITE_END_RESPAWN_ANCHOR)).build();
//                    new Identifier("morerespawnanchors", "general"))
//            .icon(() ->new ItemStack(NETHERITE_RESPAWN_ANCHOR)).entries((displayContext, entries) -> {
//        entries.add(END_RESPAWN_ANCHOR);
//                entries.add(NETHERITE_RESPAWN_ANCHOR);
//                entries.add(NETHERITE_END_RESPAWN_ANCHOR);
//            }).build();

    public static boolean respawnAfterCredits = false;

    @Override
    public void onInitialize() {

        Registry.register(Registry.BLOCK, new Identifier("morerespawnanchors", "netherite_respawn_anchor"),
                NETHERITE_RESPAWN_ANCHOR);
        Registry.register(Registry.ITEM, new Identifier("morerespawnanchors", "netherite_respawn_anchor"),
                new BlockItem(NETHERITE_RESPAWN_ANCHOR, new Item.Settings().fireproof().group(ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("morerespawnanchors", "end_respawn_anchor"),
                END_RESPAWN_ANCHOR);
        Registry.register(Registry.ITEM, new Identifier("morerespawnanchors", "end_respawn_anchor"),
                new BlockItem(END_RESPAWN_ANCHOR, new Item.Settings().group(ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("morerespawnanchors", "netherite_end_respawn_anchor"),
                NETHERITE_END_RESPAWN_ANCHOR);
        Registry.register(Registry.ITEM, new Identifier("morerespawnanchors", "netherite_end_respawn_anchor"),
                new BlockItem(NETHERITE_END_RESPAWN_ANCHOR, new Item.Settings().group(ITEM_GROUP).fireproof()));

        END_RESPAWN_ANCHOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("morerespawnanchors", "end_respawn_anchor"),
                FabricBlockEntityTypeBuilder.create(EndRespawnAnchorBlockEntity::new, END_RESPAWN_ANCHOR).build(null));

        NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("morerespawnanchors", "netherite_end_respawn_anchor"),
                FabricBlockEntityTypeBuilder.create(NetheriteEndRespawnAnchorBlockEntity::new, NETHERITE_END_RESPAWN_ANCHOR).build(null));

        DispenserBlock.registerBehavior(Items.ENDER_PEARL, new FallibleItemDispenserBehavior() {
            public ItemStack dispenseSilently(BlockPointer pointer, ItemStack stack) {
                Direction direction = pointer.getBlockState().get(DispenserBlock.FACING);
                BlockPos blockPos = pointer.getPos().offset(direction);
                World world = pointer.getWorld();
                BlockState blockState = world.getBlockState(blockPos);
                Block block = blockState.getBlock();
                this.setSuccess(true);
                if (blockState.isOf(END_RESPAWN_ANCHOR) || blockState.isOf(NETHERITE_END_RESPAWN_ANCHOR)) {
                    BaseRespawnAnchor respawnAnchor = (BaseRespawnAnchor) block;
                    if (blockState.get(respawnAnchor.getChargesProperty()) != respawnAnchor.getMaxCharges()) {
                        respawnAnchor.charge(world, blockPos, blockState);
                        stack.decrement(1);
                    } else {
                        this.setSuccess(false);
                    }

                    return stack;
                } else {
                    return super.dispenseSilently(pointer, stack);
                }
            }
        });


    }
}
