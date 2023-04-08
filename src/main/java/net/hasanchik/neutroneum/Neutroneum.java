package net.hasanchik.neutroneum;

import com.mojang.logging.LogUtils;
import net.hasanchik.neutroneum.block.ModBlocks;
import net.hasanchik.neutroneum.item.ModCreativeModeTabs;
import net.hasanchik.neutroneum.item.ModItems;
import net.hasanchik.neutroneum.util.ModItemProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Neutroneum.MOD_ID)
public class Neutroneum
{
    //!!TEST!!
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "neutroneum";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public Neutroneum() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::clientSetup);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        //NTS: you can add items to multiple tabs at once
        if(event.getTab() == ModCreativeModeTabs.NEUTRONEUM_TAB) {
            event.accept(ModItems.NEUTRONEUM_INGOT);
            event.accept(ModItems.RAW_NEUTRONEUM);
            event.accept(ModItems.METAL_DETECTOR);

            event.accept(ModBlocks.NEUTRONEUM_BLOCK);
            event.accept(ModBlocks.DEEPSLATE_NEUTRONEUM_ORE);
            event.accept(ModBlocks.NEUTRONEUM_ORE);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.NEUTRONEUM_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.DEEPSLATE_NEUTRONEUM_ORE);
            event.accept(ModBlocks.NEUTRONEUM_ORE);
        }

        if(event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.METAL_DETECTOR);
        }
    }

    /*
    *You can use SubscribeEvent and let the Event Bus discover methods to call
    *@SubscribeEvent
    *public void onServerStarting(ServerStartingEvent event) {
    *     Do something when the server starts
    *    LOGGER.info("HELLO from server starting");
    *}
    */

    private void clientSetup(final FMLClientSetupEvent event) {
        ModItemProperties.addCustomItemProperties();
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }
}
