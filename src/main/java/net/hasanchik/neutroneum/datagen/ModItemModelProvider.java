package net.hasanchik.neutroneum.datagen;

import net.hasanchik.neutroneum.Neutroneum;
import net.hasanchik.neutroneum.item.ModItems;
import net.hasanchik.neutroneum.item.custom.MetalDetectorItem.MetalDetectorItem;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Neutroneum.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.NEUTRONEUM_INGOT);
        simpleItem(ModItems.RAW_NEUTRONEUM);
        metalDetectorItem(ModItems.METAL_DETECTOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return  withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Neutroneum.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handHeldItem(RegistryObject<Item> item) {
        return  withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Neutroneum.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder metalDetectorItem(RegistryObject<Item> item) {
        for(Integer frame = 0; frame <= MetalDetectorItem.animationFrames-1; frame++) {
            String frameString = frame.toString();
            if (frame < 10) {
                frameString = "0" + frameString;
            }

            //Initialize all the individual animation frame json files
            withExistingParent(item.getId().getPath() + "_" + frameString,
                    new ResourceLocation("item/generated")).texture("layer0",
                    new ResourceLocation(Neutroneum.MOD_ID, "item/" + item.getId().getPath() + "_" + frameString));

            //Not worth the effort to also make the predicate json file automatically
        }

        return null;
    }
}
