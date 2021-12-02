package com.company;

public class Component {

    enum  InstalledComponent {
        NOT_FITTED,
        COMPONENT_1,
        COMPONENT_2,
        COMPONENT_3
    };

    enum ComponentID {
        Engine,
        MguKinetic,
        MguHeat,
        TurboCharger,
        EnergyStore,
        ControlElectronics,
        Gearbox
    }

    private int expectedLifespan;
    private int trackTime;
    private int wear;

    Component(ComponentID componentName) {
        switch (componentName) {
            case Engine:
                expectedLifespan = 340;
                break;
            case MguKinetic:
                expectedLifespan = 800;
                break;
            case MguHeat:
                expectedLifespan = 700;
                break;
            case TurboCharger:
                expectedLifespan = 500;
                break;
            case EnergyStore:
                expectedLifespan = 900;
                break;
            case ControlElectronics:
                expectedLifespan = 450;
                break;
            case Gearbox:
                expectedLifespan = 380;
                break;
        }

        trackTime = 0;
        wear = 0;
    }

    int GetExpectedLifespan() {
        return expectedLifespan;
    }
    int GetTrackTime() {
        return trackTime;
    }
    int GetWear() {
        return wear;
    }
    void SetExpectedLifespan(int newExpectedLifespan) {
        expectedLifespan = newExpectedLifespan;
    }
    void SetTrackTime(int newTrackTime) {
        trackTime = newTrackTime;
    }
    void SetWear(int newWear) {
        wear = newWear;
    }
}
