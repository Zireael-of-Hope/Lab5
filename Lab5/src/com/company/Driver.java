package com.company;

public class Driver {
    private String name = "NoName";
    private int number = 0;

    private int overallRating = 0;
    private int experience = 0;
    private int racecraft = 0;
    private int awareness = 0;
    private int pace = 0;
    private double salary = 0;

    Driver() {
        name = "NoName";
        number = 0;
        overallRating = 0;
        experience = 0;
        racecraft = 0;
        awareness = 0;
        pace = 0;
        salary = 0f;
    }

    void SetName(String newName) {
        name = newName;
    }

    void SetNumber(int newNumber) {
        number = newNumber;
    }

    void SetOverallRating(int newOverallRating) {
        overallRating = newOverallRating;
    }

    void SetExperience(int newExperience) {
        experience = newExperience;
    }

    void SetRacecraft(int newRacecraft) {
        racecraft = newRacecraft;
    }

    void SetAwareness(int newAwareness) {
        awareness = newAwareness;
    }

    void SetPace(int newPace) {
        pace = newPace;
    }

    void SetSalary(double newSalary) {
        salary = newSalary;
    }

    void GetInfo() {
       System.out.print(Color.ANSI_GREEN + "Driver " + Color.ANSI_RESET);

        System.out.println(name + " " + number);
        System.out.println("    Overall rating: " + overallRating);
        System.out.println("    Experience: " + experience);
        System.out.println("    Racecraft: " + racecraft);
        System.out.println("    Awareness: " + awareness);
        System.out.println("    Pace: " + pace);
        System.out.println("    Salary: " + salary);
    }

    String GetName() {
        return name;
    }

    boolean isDriverHired() {
        if (name == "NoName")
            return false;
        else
            return true;
    }

    String returnDriverName() {
        return name;
    }
}
