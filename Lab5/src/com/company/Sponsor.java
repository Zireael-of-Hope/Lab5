package com.company;

import java.util.Scanner;

enum SponsorTargetRace {
    PODIUM,
    TOP_5,
    TOP_10,
    FINISH
}

enum SponsorTargetSeason {
    CHAMP,
    TOP_THREE,
    TOP_FIVE,
    EVERY_RACE_PARTICIPATE,
    NOT_LAST
}

public class Sponsor {
    Scanner scanner = new Scanner(System.in);

    private String name;
    private int color;
    private SponsorTargetRace targetRace;
    private SponsorTargetSeason targetSeason;
    private double paymentPerRace;
    private double targetBonusRatio;

    Sponsor() {
        name = "NoName";
        color = 15;
        targetRace = SponsorTargetRace.FINISH;
        targetSeason = SponsorTargetSeason.NOT_LAST;
        paymentPerRace = 0;
        targetBonusRatio = 1;
    }

    void SetName(String newName) {
        name = newName;
    }

    void SetColor_interface() {
        boolean isPass;

        System.out.println(Color.ANSI_GREEN + "1) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_RED + "2) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_YELLOW + "3) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLACK + "4) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_BLUE + "5) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_CYAN + "6) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_WHITE + "7) 0000000000000000000000000" + Color.ANSI_RESET);
        System.out.println(Color.ANSI_PURPLE + "8) 0000000000000000000000000" + Color.ANSI_RESET);

        System.out.print("\nChoose the color you like: ");

        do {
            isPass = false;
            color = scanner.nextInt();
            if (color > 0 && color < 8)
                isPass = true;
        } while (isPass == false);
    }

    void SetTargetRace_interface() {
        boolean isPass;
        int decision;

        System.out.println("1) Podium");
        System.out.println("2) TOP 5");
        System.out.println("3) TOP 10");
        System.out.println("4) To Finish\n");
        System.out.print("Select sponsor's target for the race: ");

        do {
            isPass = false;
            decision = scanner.nextInt();
            if (decision >= 1 && decision <= 4)
                isPass = true;
        } while (isPass == false);

        switch (decision) {
            case 1:
                targetRace = SponsorTargetRace.PODIUM;
                break;
            case 2:
                targetRace = SponsorTargetRace.TOP_5;
                break;
            case 3:
                targetRace = SponsorTargetRace.TOP_10;
                break;
            case 4:
                targetRace = SponsorTargetRace.FINISH;
                break;
        }
    }

    void SetTargetSeason_interface() {
        boolean isPass;
        int decision;

        System.out.println("1) One of the driver is champion");
        System.out.println("2) TOP 3");
        System.out.println("3) TOP 5");
        System.out.println("4) Finish every race");
        System.out.println("5) Not last in the season\n");
        System.out.print("Select sponsor's target for the season: ");

        do {
            isPass = false;
            decision = scanner.nextInt();
            if (decision >= 1 && decision <= 4)
                isPass = true;
        } while (isPass == false);

        switch (decision) {
            case 1:
                targetSeason = SponsorTargetSeason.CHAMP;
                break;
            case 2:
                targetSeason = SponsorTargetSeason.TOP_THREE;
                break;
            case 3:
                targetSeason = SponsorTargetSeason.TOP_FIVE;
                break;
            case 4:
                targetSeason = SponsorTargetSeason.EVERY_RACE_PARTICIPATE;
                break;
            case 5:
                targetSeason = SponsorTargetSeason.NOT_LAST;
                break;
        }
    }

    void SetPaymentPerRace(double newPaymentPerRace) {
        paymentPerRace = newPaymentPerRace;
    }

    void SetTargetBonusRatio(double newTargetBonusRatio) {
        targetBonusRatio = newTargetBonusRatio;
    }

    void GetInfoSponsor() {
        int i;
        boolean isPass;
        char decision;


       System.out.println("Sponsor " + name);

        System.out.print("Color: ");
        switch(color) {
            case 1:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_GREEN + '\u2588' + Color.ANSI_RESET);
                break;
            case 2:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_RED + '\u2588' + Color.ANSI_RESET);
                break;
            case 3:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_YELLOW + '\u2588' + Color.ANSI_RESET);
                break;
            case 4:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_BLACK + '\u2588' + Color.ANSI_RESET);
                break;
            case 5:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_BLUE + '\u2588' + Color.ANSI_RESET);
                break;
            case 6:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_CYAN + '\u2588' + Color.ANSI_RESET);
                break;
            case 7:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_WHITE + '\u2588' + Color.ANSI_RESET);
                break;
            case 8:
                for (i = 0; i < 20; i++)
                    System.out.print(Color.ANSI_PURPLE + '\u2588' + Color.ANSI_RESET);
                break;
        };

        System.out.print("\nRace Target: ");
        switch (targetRace) {
            case PODIUM:
                System.out.println("Podium");
                break;
            case TOP_5:
                System.out.println("TOP 5");
                break;
            case TOP_10:
                System.out.println("TOP 10");
                break;
            case FINISH:
                System.out.println("Cross the finish line");
                break;
        }

        System.out.print("Season Target: ");
        switch (targetSeason) {
            case CHAMP:
                System.out.println("One of the drivers is champion");
                break;
            case TOP_THREE:
                System.out.println("TOP 3");
                break;
            case TOP_FIVE:
                System.out.println("TOP 5");
                break;
            case NOT_LAST:
                System.out.println("Not Last");
                break;
        }

        System.out.println("Income per race: " + paymentPerRace);

        System.out.println("Target bonus ratio: " + targetBonusRatio);
    }

    double GetPaymentPerRace() {
        return paymentPerRace;
    }
}
