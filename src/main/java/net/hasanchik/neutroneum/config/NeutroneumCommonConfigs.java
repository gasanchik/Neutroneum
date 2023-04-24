package net.hasanchik.neutroneum.config;

import com.google.common.collect.ImmutableMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.HashMap;
import java.util.Map;

public class NeutroneumCommonConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec SPEC;

    /*
    public static final ForgeConfigSpec.ConfigValue<Integer> CITRINE_ORE_VEINS_PER_CHUNK;
    public static final ForgeConfigSpec.ConfigValue<Integer> CITRINE_ORE_VEIN_SIZE;
     */
    public static final ForgeConfigSpec.ConfigValue<Integer> DETECTABLE_METALS_METAL_DETECTOR = null;
    static {
        BUILDER.push("Configs for Neutroneum");

        /*
        CITRINE_ORE_VEINS_PER_CHUNK = BUILDER.comment("How many Citrine Ore Veins spawn per chunk!")
                .define("Veins Per Chunk", 7);
        CITRINE_ORE_VEIN_SIZE = BUILDER.comment("How many Citrine Ore Blocks spawn in one Vein!")
                .defineInRange("Vein Size", 9, 4, 20);
        */
        //DETECTABLE_METALS_METAL_DETECTOR = BUILDER.comment("Detectable metals with first tier metal detector")
        //                .define("Detectable metals", HashMap<String, HashMap<String, >>)

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
