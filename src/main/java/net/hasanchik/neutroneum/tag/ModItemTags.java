package net.hasanchik.neutroneum.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModItemTags {
    public static final TagKey<Item> DETECTABLE_ORES_METAL_DETECTOR = bind("detectable_ores_metal_detector");
    private ModItemTags() {
    }

    private static TagKey<Item> bind(String pName) {
        return TagKey.create(Registries.ITEM, new ResourceLocation(pName));
    }

    public static TagKey<Item> create(final ResourceLocation name) {
        return TagKey.create(Registries.ITEM, name);
    }
}
