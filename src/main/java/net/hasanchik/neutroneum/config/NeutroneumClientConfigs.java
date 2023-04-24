package net.hasanchik.neutroneum.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class NeutroneumClientConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    static {
        BUILDER.push("Configs for Tutorial Mod");

        // HERE DEFINE YOUR CONFIGS

        BUILDER.pop();
        SPEC = BUILDER.build();
    }
}
