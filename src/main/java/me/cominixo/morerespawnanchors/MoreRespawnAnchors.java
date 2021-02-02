package me.cominixo.morerespawnanchors;

import me.cominixo.morerespawnanchors.block.BaseRespawnAnchor;
import me.cominixo.morerespawnanchors.block.EndRespawnAnchor;
import me.cominixo.morerespawnanchors.block.NetheriteEndRespawnAnchor;
import me.cominixo.morerespawnanchors.block.NetheriteRepawnAnchor;
import me.cominixo.morerespawnanchors.block.entity.EndRespawnAnchorBlockEntity;
import me.cominixo.morerespawnanchors.block.entity.NetheriteEndRespawnAnchorBlockEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MoreRespawnAnchors implements ModInitializer {

    public static final NetheriteRepawnAnchor NETHERITE_RESPAWN_ANCHOR =
            new NetheriteRepawnAnchor(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)
                    .luminance((state) -> BaseRespawnAnchor.getLightLevel(state.get(IntProperty.of("charges", 0, 12)), 15, 12)));

    public static final EndRespawnAnchor END_RESPAWN_ANCHOR =
            new EndRespawnAnchor(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)
                    .luminance((state) -> BaseRespawnAnchor.getLightLevel(state.get(IntProperty.of("charges", 0, 4)), 15, 4)));

    public static final NetheriteEndRespawnAnchor NETHERITE_END_RESPAWN_ANCHOR =
            new NetheriteEndRespawnAnchor(FabricBlockSettings.of(Material.STONE).requiresTool().strength(50.0F, 1200.0F)
                    .luminance((state) -> BaseRespawnAnchor.getLightLevel(state.get(IntProperty.of("charges", 0, 12)), 15, 12)));


    public static BlockEntityType<EndRespawnAnchorBlockEntity> END_RESPAWN_ANCHOR_BLOCK_ENTITY;
    public static BlockEntityType<NetheriteEndRespawnAnchorBlockEntity> NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY;

    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier("morerespawnanchors", "general"),
            () -> new ItemStack(NETHERITE_RESPAWN_ANCHOR));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("morerespawnanchors", "netherite_respawn_anchor"),
                NETHERITE_RESPAWN_ANCHOR);
        Registry.register(Registry.ITEM, new Identifier("morerespawnanchors", "netherite_respawn_anchor"),
                new BlockItem(NETHERITE_RESPAWN_ANCHOR, new Item.Settings().group(ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("morerespawnanchors", "end_respawn_anchor"),
                END_RESPAWN_ANCHOR);
        Registry.register(Registry.ITEM, new Identifier("morerespawnanchors", "end_respawn_anchor"),
                new BlockItem(END_RESPAWN_ANCHOR, new Item.Settings().group(ITEM_GROUP)));

        Registry.register(Registry.BLOCK, new Identifier("morerespawnanchors", "netherite_end_respawn_anchor"),
                NETHERITE_END_RESPAWN_ANCHOR);
        Registry.register(Registry.ITEM, new Identifier("morerespawnanchors", "netherite_end_respawn_anchor"),
                new BlockItem(NETHERITE_END_RESPAWN_ANCHOR, new Item.Settings().group(ITEM_GROUP)));

        END_RESPAWN_ANCHOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("morerespawnanchors", "end_respawn_anchor"),
                BlockEntityType.Builder.create(EndRespawnAnchorBlockEntity::new, END_RESPAWN_ANCHOR).build(null));

        NETHERITE_END_RESPAWN_ANCHOR_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("morerespawnanchors", "netherite_end_respawn_anchor"),
                BlockEntityType.Builder.create(NetheriteEndRespawnAnchorBlockEntity::new, NETHERITE_END_RESPAWN_ANCHOR).build(null));


    }
}
