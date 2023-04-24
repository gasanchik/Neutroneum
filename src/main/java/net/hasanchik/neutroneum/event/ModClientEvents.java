package net.hasanchik.neutroneum.event;

import net.hasanchik.neutroneum.Neutroneum;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;

public class ModClientEvents {
    @Mod.EventBusSubscriber(modid = Neutroneum.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {

    }

    @Mod.EventBusSubscriber(modid = Neutroneum.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {

    }
}
