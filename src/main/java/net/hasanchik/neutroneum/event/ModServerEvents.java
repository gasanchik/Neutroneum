package net.hasanchik.neutroneum.event;

import net.hasanchik.neutroneum.Neutroneum;
import net.hasanchik.neutroneum.handlers.DetectableValuablesHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Neutroneum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)
public class ModServerEvents {

    private static DetectableValuablesHandler INSTANCE;
    @SubscribeEvent
    public void onResourceReload(AddReloadListenerEvent event)
    {
        INSTANCE = new DetectableValuablesHandler();
        event.addListener(INSTANCE);
    }

    static DetectableValuablesHandler getDetectableValuablesHandler() {
        if(INSTANCE == null)
            throw new IllegalStateException("Can not retrieve DetectableValuablesHandler until resources have loaded once.");
        return INSTANCE;
    }
}
