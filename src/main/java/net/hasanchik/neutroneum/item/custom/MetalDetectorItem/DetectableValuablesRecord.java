package net.hasanchik.neutroneum.item.custom.MetalDetectorItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;
import java.util.ArrayList;

public class DetectableValuablesRecord {
    private ResourceLocation detectableOreType;
    private float detectorRadiusMultiplier;
    private ArrayList<ResourceLocation> detectableOres;

    DetectableValuablesRecord(ResourceLocation detectableOreType,float detectorRadiusMultiplier, ArrayList<ResourceLocation> detectableOres) {
        setDetectableOreType(detectableOreType);
        setDetectorRadiusMultiplier(detectorRadiusMultiplier);
        setDetectableOres(detectableOres);
    }

    public DetectableValuablesRecord() {}
    public DetectableValuablesRecord loadFromJson(JsonObject jsonObject) {
        setDetectableOreType(new ResourceLocation(jsonObject.get("detectableOreType").getAsString()));
        setDetectorRadiusMultiplier(jsonObject.get("detectorRadiusMultiplier").getAsFloat());

        JsonArray detectableOresArray = jsonObject.get("detectableOres").getAsJsonArray();
        ArrayList<ResourceLocation> deserializedDetectableOresArray = new ArrayList<>();
        for (JsonElement resourceLocation : detectableOresArray) {
            deserializedDetectableOresArray.add(new ResourceLocation(resourceLocation.getAsString()));
        }
        setDetectableOres(deserializedDetectableOresArray);
        return this;
    }

    public ResourceLocation getDetectableOreType() {
        return detectableOreType;
    }

    public void setDetectableOreType(ResourceLocation detectableOreType) {
        this.detectableOreType = detectableOreType;
    }

    public float getDetectorRadiusMultiplier() {
        return detectorRadiusMultiplier;
    }

    public void setDetectorRadiusMultiplier(float detectorRadiusMultiplier) {
        this.detectorRadiusMultiplier = detectorRadiusMultiplier;
    }

    public ArrayList<ResourceLocation> getDetectableOres() {
        return detectableOres;
    }

    public void setDetectableOres(ArrayList<ResourceLocation> detectableOres) {
        this.detectableOres = detectableOres;
    }
}
