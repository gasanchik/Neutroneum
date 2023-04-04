package net.hasanchik.neutroneum.item;

import net.hasanchik.neutroneum.Neutroneum;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Neutroneum.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab NEUTRONEUM_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        NEUTRONEUM_TAB = event.registerCreativeModeTab(new ResourceLocation(Neutroneum.MOD_ID, "neutroneum_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RAW_NEUTRONEUM.get()))
                        .title(Component.translatable("creativemodetab.neutroneum")));
    }
}
