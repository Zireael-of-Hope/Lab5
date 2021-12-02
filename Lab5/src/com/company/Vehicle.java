package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Vehicle {

    Scanner scanner = new Scanner(System.in);

    enum  TyresCompound {
        NOT_INSTALLED,
        SOFT,
        MEDIUM,
        HARD
    }

    private Driver driver = new Driver();

    private String vehicleName;

    private List<String> sponsorStickers = new ArrayList<>();

    private Tyres tyreSet = new Tyres();

    private class SeasonComponents {
        double totalComponentWearRatio;
        class  PowerUnitSet {
            Component engine1 = new Component(Component.ComponentID.Engine);
            Component engine2 = new Component(Component.ComponentID.Engine);
            Component engine3 = new Component(Component.ComponentID.Engine);

            Component mguKinetic1 = new Component(Component.ComponentID.MguKinetic);
            Component mguKinetic2 = new Component(Component.ComponentID.MguKinetic);
            Component mguKinetic3 = new Component(Component.ComponentID.MguKinetic);

            Component mguHeat1 = new Component(Component.ComponentID.MguHeat);
            Component mguHeat2 = new Component(Component.ComponentID.MguHeat);
            Component mguHeat3 = new Component(Component.ComponentID.MguHeat);

            Component turboCharger1 = new Component(Component.ComponentID.TurboCharger);
            Component turboCharger2 = new Component(Component.ComponentID.TurboCharger);
            Component turboCharger3 = new Component(Component.ComponentID.TurboCharger);

            Component energyStore1 = new Component(Component.ComponentID.EnergyStore);
            Component energyStore2 = new Component(Component.ComponentID.EnergyStore);

            Component controlElectronics1 = new Component(Component.ComponentID.ControlElectronics);
            Component controlElectronics2 = new Component(Component.ComponentID.ControlElectronics);

            Component.InstalledComponent internalCombastionEngine;
            Component.InstalledComponent mguKinetic;
            Component.InstalledComponent mguHeat;
            Component.InstalledComponent energyStore;
            Component.InstalledComponent turboCharger;
            Component.InstalledComponent controlElectronics;
        }
        PowerUnitSet powerUnitSet = new PowerUnitSet();

        class GearboxSet {
            Component practiceGearbox1 = new Component(Component.ComponentID.Gearbox);
            Component practiceGearbox2 = new Component(Component.ComponentID.Gearbox);

            Component eventGearbox1 = new Component(Component.ComponentID.Gearbox);
            Component eventGearbox2 = new Component(Component.ComponentID.Gearbox);

            Component.InstalledComponent practiceGearbox;
            Component.InstalledComponent eventGearbox;
        }
        GearboxSet gearboxSet = new GearboxSet();
    }
    SeasonComponents seasonComponents = new SeasonComponents();

    Vehicle() {
        vehicleName = "NoName";
        seasonComponents.totalComponentWearRatio = 3;
        seasonComponents.powerUnitSet.internalCombastionEngine = Component.InstalledComponent.NOT_FITTED;
        seasonComponents.powerUnitSet.mguKinetic = Component.InstalledComponent.NOT_FITTED;
        seasonComponents.powerUnitSet.mguHeat = Component.InstalledComponent.NOT_FITTED;
        seasonComponents.powerUnitSet.turboCharger = Component.InstalledComponent.NOT_FITTED;
        seasonComponents.powerUnitSet.energyStore = Component.InstalledComponent.NOT_FITTED;
        seasonComponents.powerUnitSet.controlElectronics = Component.InstalledComponent.NOT_FITTED;

        seasonComponents.gearboxSet.eventGearbox = Component.InstalledComponent.NOT_FITTED;
        seasonComponents.gearboxSet.practiceGearbox = Component.InstalledComponent.NOT_FITTED;
    }

    void GetSponsorStickers() {
        int i;
        for (i = 0; i < sponsorStickers.size(); i++)
            System.out.println("  " + sponsorStickers.get(i));
    }

    void AddSponsorSticker(String newSponsorName) {
        sponsorStickers.add(newSponsorName);
    }

    boolean DeleteSponsorSticker(String nameDelete) {
        int i;
        for (i = 0; i < sponsorStickers.size(); i++ ) {
            int comparison = sponsorStickers.get(i).compareTo(nameDelete);
            if (comparison == 0) {
                sponsorStickers.remove(i);
                return true;
            }
        }
        return false;
    }

    void GetInfoTotalWear() {
        System.out.println("Total Component Wear Ratio: " + seasonComponents.totalComponentWearRatio);
    }

    void GetInfo() {
        GetInfoName();
        GetInfoDriverName();
        GetSponsorStickers();
        GetInfoTyreSet();
        GetInfoTotalWear();
        GetInfoCombastionEngine();
        GetInfoVehicleMguKinetic();
        GetInfoMguHeat();
        GetInfoTurboCharger();
        GetInfoEnergyStore();
        GetInfoControlElectronics();
        GetInfoPractiseGerbox();
        GetInfoEventGerbox();
    }

    void GetInfoName() {
        System.out.println("Vehicle Name: " + vehicleName);
    }

    void GetInfoDriverName() {
        System.out.println("Vehicle Name: " + driver.GetName());
    }

    void GetInfoTyreSet() {
        switch (tyreSet.GetTyres()) {
            case NOT_INSTALLED:
                System.out.println("Tyres aren't installed");
                break;
            case SOFT:
                System.out.println(Color.ANSI_RED + "SOFT " + Color.ANSI_RESET + "tyres are installed");
                System.out.println("  Tyre Wear: " + tyreSet.GetTyreWear());
                break;
            case MEDIUM:
                System.out.println(Color.ANSI_YELLOW + "MEDIUM " + Color.ANSI_RESET + "tyres are installed");
                System.out.println("  Tyre Wear: " + tyreSet.GetTyreWear());
                break;
            case HARD:
                System.out.println("HARD tyres are installed");
                System.out.println("  Tyre Wear: " + tyreSet.GetTyreWear());
                break;
        }
    }

    void GetInfoCombastionEngine() {
        System.out.print("Internal Combastion Engine: ");
        switch (seasonComponents.powerUnitSet.internalCombastionEngine) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.engine1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.engine1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.engine1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.engine2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.engine2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.engine2.GetWear());
                break;
            case COMPONENT_3:
                System.out.println("3");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.engine3.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.engine3.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.engine3.GetWear());
                break;
        }
    }

    void GetInfoVehicleMguKinetic() {
        System.out.print("MGU Kinetic: ");
        switch (seasonComponents.powerUnitSet.mguKinetic) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguKinetic1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguKinetic1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguKinetic1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguKinetic2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguKinetic2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguKinetic2.GetWear());
                break;
            case COMPONENT_3:
                System.out.println("3");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguKinetic3.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguKinetic3.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguKinetic3.GetWear());
                break;
        }
    }

    void GetInfoMguHeat() {
        System.out.print("MGU Heat: ");
        switch (seasonComponents.powerUnitSet.mguHeat) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguHeat1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguHeat1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguHeat1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguHeat2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguHeat2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguHeat2.GetWear());
                break;
            case COMPONENT_3:
                System.out.println("3");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguHeat3.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguHeat3.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguHeat3.GetWear());
                break;
        }
    }

    void GetInfoTurboCharger() {
        System.out.print("Turbo Charger: ");
        switch (seasonComponents.powerUnitSet.turboCharger) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.turboCharger1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.turboCharger1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.turboCharger1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.turboCharger2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.turboCharger2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.turboCharger2.GetWear());
                break;
            case COMPONENT_3:
                System.out.println("3");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.turboCharger3.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.turboCharger3.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.turboCharger3.GetWear());
                break;
        }
    }

    void GetInfoEnergyStore() {
        System.out.print("Energy Store: ");
        switch (seasonComponents.powerUnitSet.energyStore) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.energyStore1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.energyStore1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.energyStore1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.energyStore2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.energyStore2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.energyStore2.GetWear());
                break;
        }
    }

    void GetInfoControlElectronics() {
        System.out.print("Control Electronics: ");
        switch (seasonComponents.powerUnitSet.controlElectronics) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.controlElectronics1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.controlElectronics1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.controlElectronics1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.controlElectronics2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.powerUnitSet.controlElectronics2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.powerUnitSet.controlElectronics2.GetWear());
                break;
        }
    }

    void GetInfoPractiseGerbox() {
        System.out.print("Practise Gearbox: ");
        switch (seasonComponents.gearboxSet.practiceGearbox) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.practiceGearbox1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.gearboxSet.practiceGearbox1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.gearboxSet.practiceGearbox1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.practiceGearbox2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.gearboxSet.practiceGearbox2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.gearboxSet.practiceGearbox2.GetWear());
                break;
        }
    }

    void GetInfoEventGerbox() {
        System.out.print("Event Gearbox: ");
        switch (seasonComponents.gearboxSet.eventGearbox) {
            case NOT_FITTED:
                System.out.println("not fitted");
                break;
            case COMPONENT_1:
                System.out.println("1");
                System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.eventGearbox1.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.gearboxSet.eventGearbox1.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.gearboxSet.eventGearbox1.GetWear());
                break;
            case COMPONENT_2:
                System.out.println("2");
                System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.eventGearbox2.GetExpectedLifespan());
                System.out.println("  Track Time: " + seasonComponents.gearboxSet.eventGearbox2.GetTrackTime());
                System.out.println("  Wear: " + seasonComponents.gearboxSet.eventGearbox2.GetWear());
                break;
        }
    }

    void SetName(String newName) {
        vehicleName = newName;
    }

    void SetTyres_interface() {
        boolean isPass, isCycled;
        int decision;

        do {
            isCycled = true;
            Function.clearScreen();
            System.out.println(Color.ANSI_GREEN + "Current Tyres: " + Color.ANSI_RESET);

            switch (tyreSet.GetTyres()) {
                case NOT_INSTALLED:
                    System.out.println(" Tyres aren't installed");
                    break;
                case SOFT:
                    System.out.print(Color.ANSI_RED + "SOFT " + Color.ANSI_RESET + "tyres are installed");
                    System.out.println(" Tyre Wear: " + tyreSet.GetTyreWear());
                    break;
                case MEDIUM:
                    System.out.print(Color.ANSI_YELLOW + "MEDIUM " + Color.ANSI_RESET + "tyres are installed");
                    System.out.println(" Tyre Wear: " + tyreSet.GetTyreWear());
                    break;
                case HARD:
                    System.out.print("HARD tyres are installed");
                    System.out.println(" Tyre Wear: " + tyreSet.GetTyreWear());
                    break;
            }

            System.out.println(Color.ANSI_GREEN + "Available options: " + Color.ANSI_RESET);

            System.out.println("  1) " + Color.ANSI_RED + "SOFT" + Color.ANSI_RESET);
            System.out.println("  1) " + Color.ANSI_YELLOW + "MEDIUM" + Color.ANSI_RESET);
            System.out.println("  3) HARD");

            System.out.print("\nPick Option (0 - return): ");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision == 1 || decision == 2 || decision == 3 || decision == 0)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    tyreSet.SetTyres(Tyres.TyresCompound.SOFT);
                    break;
                case 2:
                    tyreSet.SetTyres(Tyres.TyresCompound.MEDIUM);
                    break;
                case 3:
                    tyreSet.SetTyres(Tyres.TyresCompound.HARD);
                    break;
                case 0:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }

    void SetComponents_interface() {
        boolean isPass, isCycled;
        int decision;

        do {
            isCycled = true;
            Function.clearScreen();

            System.out.println(Color.ANSI_GREEN + "Current Components Info:\n" + Color.ANSI_RESET);

            System.out.println("Power Unit:"  + Color.ANSI_RESET);

            System.out.print("1) "); GetInfoCombastionEngine();
            System.out.print("2) "); GetInfoVehicleMguKinetic();
            System.out.print("3) "); GetInfoMguHeat();
            System.out.print("4) "); GetInfoTurboCharger();
            System.out.print("5) "); GetInfoEnergyStore();
            System.out.print("6) "); GetInfoControlElectronics();

            System.out.println(Color.ANSI_GREEN + "\nGearbox:" + Color.ANSI_RESET);

            System.out.print("7) "); GetInfoPractiseGerbox();
            System.out.print("8) "); GetInfoEventGerbox();

            System.out.print("\nPick component you want to change (0 - return)...");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision == 1 || decision == 2 || decision == 3 || decision == 4 || decision == 5 || decision == 6 || decision == 7 || decision == 8 || decision == 0)
                    isPass = true;
            } while (isPass == false);
            Function.clearScreen();

            switch (decision) {
                case 1:
                    System.out.println(Color.ANSI_GREEN + "Internal Combastion Engine:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.engine1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.engine1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.engine1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.engine2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.engine2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.engine2.GetWear());
                    System.out.println("3:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.engine3.GetExpectedLifespan());
                    System.out.println( "  Track Time: " + seasonComponents.powerUnitSet.engine3.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.engine3.GetWear());

                    System.out.print("\nPick Engine you want to fit or press 4 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 4 || decision == 5)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.powerUnitSet.internalCombastionEngine = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.powerUnitSet.internalCombastionEngine = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.powerUnitSet.internalCombastionEngine = Component.InstalledComponent.COMPONENT_3;
                                break;
                            case 4:
                                seasonComponents.powerUnitSet.internalCombastionEngine = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 2:
                    System.out.println(Color.ANSI_GREEN + "MGU Kinetic:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguKinetic1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguKinetic1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguKinetic1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguKinetic2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguKinetic2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguKinetic2.GetWear());
                    System.out.println("3:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguKinetic3.GetExpectedLifespan());
                    System.out.println( "  Track Time: " + seasonComponents.powerUnitSet.mguKinetic3.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguKinetic3.GetWear());

                    System.out.print("\nPick MGU Kinetic you want to fit or press 4 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 4 || decision == 0)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.powerUnitSet.mguKinetic = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.powerUnitSet.mguKinetic = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.powerUnitSet.mguKinetic = Component.InstalledComponent.COMPONENT_3;
                                break;
                            case 4:
                                seasonComponents.powerUnitSet.mguKinetic = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 3:
                    System.out.println(Color.ANSI_GREEN + "MGU Heat:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguHeat1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguHeat1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguHeat1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguHeat2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.mguHeat2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguHeat2.GetWear());
                    System.out.println("3:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.mguHeat3.GetExpectedLifespan());
                    System.out.println( "  Track Time: " + seasonComponents.powerUnitSet.mguHeat3.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.mguHeat3.GetWear());

                    System.out.print("\nPick MGU Heat you want to fit or press 4 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 4 || decision == 0)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.powerUnitSet.mguHeat = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.powerUnitSet.mguHeat = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.powerUnitSet.mguHeat = Component.InstalledComponent.COMPONENT_3;
                                break;
                            case 4:
                                seasonComponents.powerUnitSet.mguHeat = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 4:
                    System.out.println(Color.ANSI_GREEN + "Turbo Charger:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.turboCharger1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.turboCharger1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.turboCharger1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.turboCharger2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.turboCharger2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.turboCharger2.GetWear());
                    System.out.println("3:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.turboCharger3.GetExpectedLifespan());
                    System.out.println( "  Track Time: " + seasonComponents.powerUnitSet.turboCharger3.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.turboCharger3.GetWear());

                    System.out.print("\nPick Turbo Charger you want to fit or press 4 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 4 || decision == 0)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.powerUnitSet.turboCharger = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.powerUnitSet.turboCharger = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.powerUnitSet.turboCharger = Component.InstalledComponent.COMPONENT_3;
                                break;
                            case 4:
                                seasonComponents.powerUnitSet.turboCharger = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 5:
                    System.out.println(Color.ANSI_GREEN + "Energy Store:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.energyStore1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.energyStore1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.energyStore1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.energyStore2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.energyStore2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.energyStore2.GetWear());

                    System.out.print("\nPick Energy Store you want to fit or press 3 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 0)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.powerUnitSet.energyStore = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.powerUnitSet.energyStore = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.powerUnitSet.energyStore = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 6:
                    System.out.println(Color.ANSI_GREEN + "Control Electronics:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.controlElectronics1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.controlElectronics1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.controlElectronics1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.powerUnitSet.controlElectronics2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.powerUnitSet.controlElectronics2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.powerUnitSet.controlElectronics2.GetWear());

                    System.out.print("\nPick Control Electronics you want to fit or press 3 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 0)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.powerUnitSet.controlElectronics = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.powerUnitSet.controlElectronics = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.powerUnitSet.controlElectronics = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 7:
                    System.out.println(Color.ANSI_GREEN + "Practise Gearbox:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.practiceGearbox1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.gearboxSet.practiceGearbox1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.gearboxSet.practiceGearbox1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.practiceGearbox2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.gearboxSet.practiceGearbox2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.gearboxSet.practiceGearbox2.GetWear());

                    System.out.print("\nPick Practise Gearbox you want to fit or press 3 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == '1' || decision == '2' || decision == '3' || decision == '0')
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case '1':
                                seasonComponents.gearboxSet.practiceGearbox = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case '2':
                                seasonComponents.gearboxSet.practiceGearbox = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case '3':
                                seasonComponents.gearboxSet.practiceGearbox = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case '0':
                                break;
                        }
                    break;
                case 8:
                    System.out.println(Color.ANSI_GREEN + "Event Gearbox:" + Color.ANSI_RESET);
                    System.out.println("1:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.practiceGearbox1.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.gearboxSet.practiceGearbox1.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.gearboxSet.practiceGearbox1.GetWear());
                    System.out.println("2:");
                    System.out.println("  Expected Lifespan: " + seasonComponents.gearboxSet.practiceGearbox2.GetExpectedLifespan());
                    System.out.println("  Track Time: " + seasonComponents.gearboxSet.practiceGearbox2.GetTrackTime());
                    System.out.println("  Wear: " + seasonComponents.gearboxSet.practiceGearbox2.GetWear());

                    System.out.print("\nPick Event Gearbox you want to fit or press 3 to take off the fitted component (0 - return)...");

                    do {
                        isPass = false;
                        decision = scanner.nextInt();
                        if (decision == 1 || decision == 2 || decision == 3 || decision == 0)
                            isPass = true;
                    } while (isPass == false);

                    if (decision != 0)
                        switch (decision) {
                            case 1:
                                seasonComponents.gearboxSet.eventGearbox = Component.InstalledComponent.COMPONENT_1;
                                break;
                            case 2:
                                seasonComponents.gearboxSet.eventGearbox = Component.InstalledComponent.COMPONENT_2;
                                break;
                            case 3:
                                seasonComponents.gearboxSet.eventGearbox = Component.InstalledComponent.NOT_FITTED;
                                break;
                            case 0:
                                break;
                        }
                    break;
                case 0:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }

    void SetDriver(Driver newDriver) {
        driver = newDriver;
    }

    void SetTotalComponentWearRatio(int aerodynamicsLevel, int powertrainLevel, int chassisLevel, int durabilityLevel) {
        double tempTotalWear = seasonComponents.totalComponentWearRatio;

        tempTotalWear = tempTotalWear * 10;

        tempTotalWear = tempTotalWear - aerodynamicsLevel - powertrainLevel - chassisLevel - durabilityLevel;

        tempTotalWear = tempTotalWear / 10;

        seasonComponents.totalComponentWearRatio = tempTotalWear;
    }
}
