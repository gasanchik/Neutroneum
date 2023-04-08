package net.hasanchik.neutroneum.util;

import net.hasanchik.neutroneum.item.ModItems;
import net.hasanchik.neutroneum.item.custom.MetalDetectorItem;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.ClampedItemPropertyFunction;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;

@OnlyIn(Dist.CLIENT)
public class ModItemProperties {
    public static void addCustomItemProperties() {

        ItemProperties.register(ModItems.METAL_DETECTOR.get(), new ResourceLocation("distance"), (st, l, e, se) -> {
            MetalDetectorItem item = (MetalDetectorItem)st.getItem();
            return item.getClosestOreDistance();
        });
    }


}
