package com.company;

import java.util.Scanner;

public class Team {
    Scanner scanner = new Scanner(System.in);

    Driver firstDriver = new Driver();
    Driver secondDriver = new Driver();
    Vehicle w11_1 = new Vehicle();
    Vehicle w11_2 = new Vehicle();
    Facility facility = new Facility();
    Sponsor mainSponsor = new Sponsor();
    Sponsor secondarySponsor = new Sponsor();

    Team() {};
    void InteractSlot() {
        int decision;
        boolean isPass, isCycled;

        do {
            isCycled = true;
            GetTeamInfo();

            System.out.println("1) Change Driver");
            System.out.println("2) Change Vehicle");
            System.out.println("3) Change Sponsor");
            System.out.println("4) Upgrade Facilities");
            System.out.println("5) Return");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision >= 1 && decision <= 5)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    ChangeDriver();
                    isCycled = true;
                    break;
                case 2:
                    ChangeVehicle();
                    isCycled = true;
                    break;
                case 3:
                    ChangeSponsor();
                    break;
                case 4:
                    facility.SetFacilityBureausLevel_interface();
                    break;
                case 5:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }

    void GetTeamInfo() {
        Function.clearScreen();

        System.out.println(Color.ANSI_GREEN + "F1 Team: \n" + Color.ANSI_RESET);

        if (firstDriver.isDriverHired()) {
            System.out.print("1) ");
            firstDriver.GetInfo();
        }
        else {
            System.out.print(Color.ANSI_GREEN + "1) Driver" + Color.ANSI_RESET);
            System.out.println(" not hired");
        }

        if (secondDriver.isDriverHired()) {
            System.out.print("\n2) ");
            secondDriver.GetInfo();
        }
        else {
            System.out.print(Color.ANSI_GREEN + "\n2) Driver" + Color.ANSI_RESET);
            System.out.println(" not hired");
        }

        System.out.print(Color.ANSI_GREEN + "\nVehicle 1: " + Color.ANSI_RESET);
        w11_1.GetInfo();

        System.out.println(Color.ANSI_GREEN + "\nVehicle 2: " + Color.ANSI_RESET);
        w11_2.GetInfo();

        System.out.println(Color.ANSI_GREEN + "\nMain Sponsor: " + Color.ANSI_RESET);
        mainSponsor.GetInfoSponsor();

        System.out.println(Color.ANSI_GREEN + "\nSecondary Sponsor: " + Color.ANSI_RESET);
        secondarySponsor.GetInfoSponsor();

        System.out.println(Color.ANSI_GREEN + "\nFacilities:" + Color.ANSI_RESET);
        facility.GetInfoBureauAerodynamics();
        facility.GetInfoBureauPowertrain();
        facility.GetInfoBureauChassis();
        facility.GetInfoBureauDurability();
    }

    void ChangeDriver() {
        int decision;
        boolean isPass, isCycled;

        do {
            isCycled = true;
            Function.clearScreen();
            System.out.println("1) Change First Driver");
            System.out.println("2) Change Second Driver");
            System.out.println("3) Return");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision >= 1 && decision <= 3)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    SubChangeDriver(1);
                    break;
                case 2:
                    SubChangeDriver(2);
                    break;
                case 3:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }
    void SubChangeDriver(int whichDriver) {

        String tempString;
        int tempInt;
        double tempDouble;
        Function.clearScreen();

        System.out.print("Enter Driver's Name: ");
        scanner.nextLine();
        tempString = scanner.nextLine();
        if (whichDriver == 1) firstDriver.SetName(tempString);
        else secondDriver.SetName(tempString);

        System.out.print("Enter Driver's Number: ");
        tempInt = scanner.nextInt();
        if (whichDriver == 1) firstDriver.SetNumber(tempInt);
        else secondDriver.SetNumber(tempInt);

        System.out.print("Enter Driver's Overall Rating: ");
        tempInt = scanner.nextInt();
        if (whichDriver == 1) firstDriver.SetOverallRating(tempInt);
        else secondDriver.SetOverallRating(tempInt);

        System.out.print("Enter Driver's Experience: ");
        tempInt = scanner.nextInt();
        if (whichDriver == 1) firstDriver.SetExperience(tempInt);
        else secondDriver.SetExperience(tempInt);

        System.out.print("Enter Driver's Racecraft: ");
        tempInt = scanner.nextInt();
        if (whichDriver == 1) firstDriver.SetRacecraft(tempInt);
        else secondDriver.SetRacecraft(tempInt);

        System.out.print("Enter Driver's Awareness: ");
        tempInt = scanner.nextInt();
        if (whichDriver == 1) firstDriver.SetAwareness(tempInt);
        else secondDriver.SetAwareness(tempInt);

        System.out.print("Enter Driver's Pace: ");
        tempInt = scanner.nextInt();
        if (whichDriver == 1) firstDriver.SetPace(tempInt);
        else secondDriver.SetPace(tempInt);

        System.out.print("Enter Driver's salary: ");
        tempDouble= scanner.nextDouble();
        if (whichDriver == 1) firstDriver.SetSalary(tempDouble);
        else secondDriver.SetSalary(tempInt);
    }

    void ChangeVehicle() {
        int decision;
        boolean isPass, isCycled;

        do {
            Function.clearScreen();

            isCycled = true;
            System.out.println("1) Change Vehicle 1");
            System.out.println("2) Change Vehicle 2");
            System.out.println("3) Return\n");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision >= 1 && decision <= 3)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    SubChangeVehicle(1);
                    isCycled = true;
                    break;
                case 2:
                    SubChangeVehicle(2);
                    isCycled = true;
                    break;
                case 3:
                    isCycled = false;
                    break;
            }
        } while (isCycled == true);
    }
    void SubChangeVehicle(int carNumber) {
        int decision;
        boolean isPass, isCycled;
        String tempString;
        do {
            isCycled = true;
            Function.clearScreen();

            System.out.println("1) Change Vehicle name");
            System.out.println("2) Change Vehicle driver");
            System.out.println("3) Change Vehicle components");
            System.out.println("4) Change Vehicle Tyres");
            System.out.println("5) Sticker Management");
            System.out.println("6) Update Vehicle total component wear ratio due to facilities level");
            System.out.println("7) Return\n");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision >= 1 && decision <= 7)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    Function.clearScreen();

                    System.out.print("Enter new Vehicle Name: ");
                    tempString = scanner.nextLine();
                    if (carNumber == 1) w11_1.SetName(tempString);
                    else w11_2.SetName(tempString);
                    break;
                case 2:
                    do {
                        Function.clearScreen();

                        System.out.println("Which Driver you want to assign on this Vehicle:");
                        firstDriver.GetInfo();
                        System.out.println("");
                        secondDriver.GetInfo();

                        System.out.println("1) Assign First Driver");
                        System.out.println("2) Assign Second Driver");
                        System.out.println("3) Return\n");

                        do {
                            isPass = false;
                            decision = scanner.nextInt();
                            if (decision >= 1 && decision <= 3)
                                isPass = true;
                        } while (isPass == false);

                        switch (decision) {
                            case 1:
                                if (firstDriver.isDriverHired())
                                    if (carNumber == 1)
                                        w11_1.SetDriver(firstDriver);
                                    else w11_2.SetDriver(firstDriver);
                                break;
                            case 2:
                                if (secondDriver.isDriverHired())
                                    if (carNumber == 1)
                                        w11_1.SetDriver(secondDriver);
                                    else w11_2.SetDriver(secondDriver);
                                break;
                            case 3:
                                isCycled = false;
                                break;
                        }
                    } while (isCycled);
                    isCycled = true;
                    break;
                case 3:
                    if (carNumber == 1) w11_1.SetComponents_interface();
                    else w11_2.SetComponents_interface();
                    isCycled = true;
                    break;
                case 4:
                    if (carNumber == 1) w11_1.SetTyres_interface();
                    else w11_2.SetTyres_interface();
                    break;
                case 5:
                    do {
                        isCycled = true;
                        Function.clearScreen();
                        System.out.println(Color.ANSI_GREEN + "Stickers on the Vehicle:" + Color.ANSI_RESET);
                        if (carNumber == 1)
                            w11_1.GetSponsorStickers();
                        else w11_2.GetSponsorStickers();

                        System.out.println("\n1) Add Sticker on the Vehicle");
                        System.out.println("2) Delete Sticker on the Vehicle");
                        System.out.println("3) Return\n");

                        do {
                            isPass = false;
                            decision = scanner.nextInt();
                            if (decision >= 1 && decision <= 3)
                                isPass = true;
                        } while (isPass == false);

                        switch (decision) {
                            case 1:
                                Function.clearScreen();

                                System.out.print("Enter name of the new sticker: ");
                                scanner.nextLine();
                                tempString = scanner.nextLine();
                                if (carNumber == 1)
                                    w11_1.AddSponsorSticker(tempString);
                                else w11_2.AddSponsorSticker(tempString);

                                break;
                            case 2:
                                Function.clearScreen();

                                System.out.print("Enter name of the sticker to delete: ");
                                scanner.nextLine();
                                tempString = scanner.nextLine();

                                if (carNumber == 1)
                                    if (w11_1.DeleteSponsorSticker(tempString))
                                        System.out.println("Sticker has been deleted");
                                    else System.out.println("No sticker to delete");
                                else if (w11_2.DeleteSponsorSticker(tempString))
                                    System.out.println("Sticker has been deleted");
                                else System.out.println("No sticker to delete");

                                break;
                            case 3:
                                isCycled = false;
                                break;
                        }
                    } while (isCycled);
                    isCycled = true;
                    break;
                case 6:
                    if (carNumber == 1) w11_1.SetTotalComponentWearRatio(facility.ReturnAerodynamicsLevel(), facility.ReturnPowertrainLevel(), facility.ReturnChassisLevel(), facility.ReturnDurabilityLevel());
                    else w11_2.SetTotalComponentWearRatio(facility.ReturnAerodynamicsLevel(), facility.ReturnPowertrainLevel(), facility.ReturnChassisLevel(), facility.ReturnDurabilityLevel());
                    break;
                case 7:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }

    void ChangeSponsor() {
        int decision;
        boolean isPass, isCycled;

        do {
            Function.clearScreen();
            isCycled = true;

            System.out.println("1) Change Main Sponsor");
            System.out.println("2) Change Secondary Sponsor");
            System.out.println("3) Return");

            do {
                isPass = false;
                decision = scanner.nextInt();
                if (decision >= 1 && decision <= 3)
                    isPass = true;
            } while (isPass == false);

            switch (decision) {
                case 1:
                    SubchangeSposnor(1);
                    break;
                case 2:
                    SubchangeSposnor(2);
                    break;
                case 3:
                    isCycled = false;
                    break;
            }
        } while (isCycled);
    }
    void SubchangeSposnor(int whichSponsor) {
        int decision;
        boolean isPass, isCycled;
        String tempString;
        double tempDouble;

        Function.clearScreen();

        System.out.print("Enter name of the main sponsor: ");
        scanner.nextLine();
        tempString = scanner.nextLine();
        if (whichSponsor == 1) mainSponsor.SetName(tempString);
        else secondarySponsor.SetName(tempString);

        System.out.println("");
        if (whichSponsor == 1) mainSponsor.SetColor_interface();
        else secondarySponsor.SetColor_interface();

        System.out.println("");
        if (whichSponsor == 1) mainSponsor.SetTargetRace_interface();
        else secondarySponsor.SetTargetRace_interface();

        System.out.println("\n");
        if (whichSponsor == 1) mainSponsor.SetTargetSeason_interface();
        else secondarySponsor.SetTargetSeason_interface();

        System.out.println("\n");
        System.out.print("Enter sponsor's payment per race: ");
        tempDouble = scanner.nextDouble();
        if (whichSponsor == 1) mainSponsor.SetPaymentPerRace(tempDouble);
        else secondarySponsor.SetPaymentPerRace(tempDouble);

        System.out.print("\nEnter sponsor's target bonus ratio: ");
        tempDouble = scanner.nextDouble();
        if (whichSponsor == 1) mainSponsor.SetTargetBonusRatio(tempDouble);
        else secondarySponsor.SetTargetBonusRatio(tempDouble);
    }
}
