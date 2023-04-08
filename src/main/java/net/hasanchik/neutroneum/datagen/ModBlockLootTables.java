package net.hasanchik.neutroneum.datagen;

import net.hasanchik.neutroneum.block.ModBlocks;
import net.hasanchik.neutroneum.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {

    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.NEUTRONEUM_BLOCK.get());

        add(ModBlocks.NEUTRONEUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NEUTRONEUM_ORE.get(), ModItems.RAW_NEUTRONEUM.get()));
        add(ModBlocks.DEEPSLATE_NEUTRONEUM_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_NEUTRONEUM_ORE.get(), ModItems.RAW_NEUTRONEUM.get()));
    }

    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
