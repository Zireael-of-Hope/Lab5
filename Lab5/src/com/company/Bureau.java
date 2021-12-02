package com.company;

public class Bureau {
    private int level;
    private float fabrication;
    private float buildTime;
    private float qualityControl;
    private float resourcePointGeneration;

    Bureau() {
        level = 1;
        fabrication = 1f;
        buildTime = 1f;
        qualityControl = 0.2f;
        resourcePointGeneration = 1f;
    }

    int GetLevel() {
        return level;
    }

    float GetFabrication() {
        return fabrication;
    }

    float GetBuildTime() {
        return buildTime;
    }

    float GetQualityControl(){
        return qualityControl;
    }

    float GetResourcePointGeneration(){
        return resourcePointGeneration;
    }

    void UpgradeBureau() {
        level++;
        fabrication = fabrication - 0.15f;
        buildTime = buildTime - 0.15f;
        qualityControl = qualityControl - 0.06f;
        resourcePointGeneration = resourcePointGeneration + 0.2f;
    }
}
