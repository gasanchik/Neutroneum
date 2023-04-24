package net.hasanchik.neutroneum.handlers;

import java.util.*;

import net.hasanchik.neutroneum.item.custom.MetalDetectorItem.DetectableValuablesRecord;
import net.minecraft.world.level.storage.loot.Deserializers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;

import net.minecraft.server.packs.resources.SimpleJsonResourceReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.resources.ResourceLocation;

public class DetectableValuablesHandler extends SimpleJsonResourceReloadListener {
    private static final Logger LOGGER = LogManager.getLogger();
    private Map<ResourceLocation, Map<ResourceLocation, DetectableValuablesRecord>> detectablesData = ImmutableMap.of();
    private static final Gson GSON_INSTANCE = Deserializers.createFunctionSerializer().create();
    private static final String FOLDER = "itemConfigs/detectors";

    public DetectableValuablesHandler() {
        super(GSON_INSTANCE, FOLDER);
    }

    @Override
    protected void apply(Map<ResourceLocation, JsonElement> jsonMap, ResourceManager resourceManagerIn, ProfilerFiller profilerIn) {
        ImmutableMap.Builder<ResourceLocation, Map<ResourceLocation, DetectableValuablesRecord>> builder = ImmutableMap.builder();
        //ResourceLocation detectorJSONFiles = new ResourceLocation("neutroneum", FOLDER);

        /*
        System.out.println(this.registeredDetectableData);*/
        detectablesData.clear();

        jsonMap.forEach((identifier, jsonElement) -> {
            try {
                Map map = GSON_INSTANCE.fromJson(jsonElement, ImmutableMap.class);
                Map deserializedMap = ImmutableMap.of();
                map.forEach((identifier2, jsonElement2) -> {
                    DetectableValuablesRecord detectableValuableData = new DetectableValuablesRecord().loadFromJson(jsonElement.getAsJsonObject());
                    deserializedMap.put(identifier2, detectableValuableData);
                });
                builder.put(identifier, deserializedMap);
            } catch (Exception exception) {
                LOGGER.error("Failed parse detectableValuableData {}", identifier, exception);
            }
        });

        this.detectablesData = builder.build();
    }

    public DetectableValuablesRecord getDetectableValuableData(ResourceLocation metalDetector, ResourceLocation detectableValuable) {
        return detectablesData.get(metalDetector).get(detectableValuable);
    }


}
