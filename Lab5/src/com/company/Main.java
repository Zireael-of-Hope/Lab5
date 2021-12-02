package com.company;

import java.util.logging.ConsoleHandler;

public class Main {

    public static void main(String[] args) {
        boolean isPass;
        int decision;

        Team[] myf1team = new Team[3];
        for (int i = 0; i < 3; i++)
            myf1team[i] = null;

        do {
            Function.clearScreen();
            isPass = false;
            decision = Function.choosingTeam(myf1team);
            if (decision != 3) {
                myf1team[decision].InteractSlot();
            }
        } while (isPass == false);
    }
}
