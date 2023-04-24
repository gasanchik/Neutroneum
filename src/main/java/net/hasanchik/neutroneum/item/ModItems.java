package net.hasanchik.neutroneum.item;

import net.hasanchik.neutroneum.Neutroneum;
import net.hasanchik.neutroneum.item.custom.MetalDetectorItem.MetalDetectorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Neutroneum.MOD_ID);
    public static final RegistryObject<Item> NEUTRONEUM_INGOT = ITEMS.register("neutroneum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_NEUTRONEUM = ITEMS.register("raw_neutroneum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
