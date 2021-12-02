package com.company;

import java.util.Scanner;

public class Facility {
    Scanner scanner = new Scanner(System.in);

    private Bureau aerodynamics = new Bureau();
    private Bureau powertrain = new Bureau();
    private Bureau chassis = new Bureau();
    private Bureau durability = new Bureau();

    Facility() {

    }

    void GetInfoBureauAerodynamics() {
        System.out.println("Aerodynamics: ");
        System.out.println("   Level: " + aerodynamics.GetLevel());
        System.out.println("   Fabrication: " + aerodynamics.GetFabrication());
        System.out.println("   Build Time: " + aerodynamics.GetBuildTime());
        System.out.println("   Quality Control: " + aerodynamics.GetQualityControl());
        System.out.println("   Duraresource Point Generationbility: " + aerodynamics.GetResourcePointGeneration() + "\n");
    }

    void GetInfoBureauPowertrain() {
        System.out.println("Powertrain: ");
        System.out.println("   Level: " + powertrain.GetLevel());
        System.out.println("   Fabrication: " + powertrain.GetFabrication());
        System.out.println("   Build Time: " + powertrain.GetBuildTime());
        System.out.println("   Quality Control: " + powertrain.GetQualityControl());
        System.out.println("   Duraresource Point Generationbility: " + powertrain.GetResourcePointGeneration() + "\n");
    }

    void GetInfoBureauChassis() {
        System.out.println("Chassis: ");
        System.out.println("   Level: " + chassis.GetLevel());
        System.out.println("   Fabrication: " + chassis.GetFabrication());
        System.out.println("   Build Time: " + chassis.GetBuildTime());
        System.out.println("   Quality Control: " + chassis.GetQualityControl());
        System.out.println("   Duraresource Point Generationbility: " + chassis.GetResourcePointGeneration() + "\n");
    }

    void GetInfoBureauDurability() {
        System.out.println("Durability: ");
        System.out.println("   Level: " + durability.GetLevel());
        System.out.println("   Fabrication: " + durability.GetFabrication());
        System.out.println("   Build Time: " + durability.GetBuildTime());
        System.out.println("   Quality Control: " + durability.GetQualityControl());
        System.out.println("   Duraresource Point Generationbility: " + durability.GetResourcePointGeneration() + "\n");
    }
    void SetFacilityBureausLevel_interface() {
        boolean isPass, isCycled;
        int decision;

        do {
            isCycled = true;
            Function.clearScreen();

            System.out.println(Color.ANSI_GREEN + "Bereaus:\n" + Color.ANSI_RESET);

            System.out.print("1) "); GetInfoBureauAerodynamics();
            System.out.println("");
            System.out.print("2) "); GetInfoBureauPowertrain();
            System.out.println("");
            System.out.print("3) "); GetInfoBureauChassis();
            System.out.println("");
            System.out.print("4) "); GetInfoBureauDurability();

            System.out.print("\nPick Bureau you want to upgrade (0 - return)...");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision == 1 || decision == 2 || decision == 3 || decision == 4 || decision == 0)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    if (aerodynamics.GetLevel() < 4) {
                        System.out.print(Color.ANSI_GREEN + "\nAerodynamics Bureau has been upgraded." + Color.ANSI_RESET);
                        aerodynamics.UpgradeBureau();
                    }
                    break;
                case 2:
                    if (powertrain.GetLevel() < 4) {
                        System.out.print(Color.ANSI_GREEN + "\nPowertrain Bureau has been upgraded." + Color.ANSI_RESET);
                        powertrain.UpgradeBureau();
                    }
                    break;
                case 3:
                    if (chassis.GetLevel() < 4) {
                        System.out.print(Color.ANSI_GREEN + "\nChassis Bureau has been upgraded." + Color.ANSI_RESET);
                        chassis.UpgradeBureau();
                    }
                    break;
                case 4:
                    if (durability.GetLevel() < 4) {
                        System.out.print(Color.ANSI_GREEN + "\nDurability Bureau has been upgraded." + Color.ANSI_RESET);
                        durability.UpgradeBureau();
                    }
                    break;
                case 0:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }

    int ReturnAerodynamicsLevel() {
        return aerodynamics.GetLevel();
    }

    int ReturnPowertrainLevel() {
        return powertrain.GetLevel();
    }

    int ReturnChassisLevel() {
        return chassis.GetLevel();
    }

    int ReturnDurabilityLevel() {
        return durability.GetLevel();
    }
}
