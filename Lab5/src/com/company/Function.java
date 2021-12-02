package com.company;

import java.util.Scanner;

public class Function {

    public final static void clearScreen()
    {
       System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public static int choosingTeam(Team [] myf1team)
    {
        Scanner scanner = new Scanner(System.in);

        boolean isPass;
        int decision;
        int i;

        for (i = 0; i < 3; i++) {
            System.out.println("\n" + (i+1) + ") ");
            if (myf1team[i] != null) {
                System.out.println(Color.ANSI_GREEN + "\nDrivers:" + Color.ANSI_RESET);
                System.out.println("1) " + myf1team[i].firstDriver.GetName());
                System.out.println("2) " + myf1team[i].secondDriver.GetName());

                System.out.println(Color.ANSI_GREEN + "\nVehicles:" + Color.ANSI_RESET);
                System.out.print("1) "); myf1team[i].w11_1.GetInfoName();
                System.out.print("2) "); myf1team[i].w11_2.GetInfoName();
            }
            else {
                System.out.println("Empty Slot\n");
            }
        }

        System.out.print("Enter slot you want to modify. (4 - clear 1 slot, 5 - clear 2 slot, 6 - clear - 3 slot)... ");

        do {
            isPass = false;
            decision = scanner.nextInt();
            if (decision >= 1 && decision <= 6)
                isPass = true;
        } while (isPass == false);

        switch (decision) {
            case 1:
                if (myf1team[0] == null) {
                    myf1team[0] = new Team();
                }
                return 0;
            case 2:
                if (myf1team[1] == null) {
                    myf1team[1] = new Team();
                }
                return 1;
            case 3:
                if (myf1team[2] == null) {
                    myf1team[2] = new Team();
                }
                return 2;
            case 4:
                if (myf1team[0] != null) {
                    myf1team[0] = null;
                }
                return 3;
            case 5:
                if (myf1team[1] != null) {
                    myf1team[1] = null;
                }
                return 3;
            case 6:
                if (myf1team[2] != null) {
                    myf1team[2] = null;
                }
                return 3;
        }
        return 0;
    }
}
