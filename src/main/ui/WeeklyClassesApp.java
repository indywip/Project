package ui;

import model.WeeklyClasses;

import java.util.Scanner;

// Student classes per week application
public class WeeklyClassesApp {
    private WeeklyClasses mySchedule;
    private Scanner input;

    // EFFECTS: runs the weekly classes application
    public WeeklyClassesApp() {
        runApp();
    }

    // MODIFIES: this
    // EFFECTS: processes user input
    private void runApp() {
        boolean keepGoing = true;
        String command = null;

        init();

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("4")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }

            System.out.println("\nComplete");
        }
    }


    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("1")) {
            addClass();
        } else if (command.equals("2")) {
            removeClass();
        } else if (command.equals("3")) {
            printSchedule(mySchedule);
        } else {
            System.out.println("Invalid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes schedule
    private void init() {
        mySchedule = new WeeklyClasses("Joe");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect number from:");
        System.out.println("\t1. Add a class");
        System.out.println("\t2. Remove a class");
        System.out.println("\t3. View current schedule");
        System.out.println("\t4. Complete");
    }

    // MODIFIES: this
    // EFFECTS: adds a class to a particular day in the schedule
    private void addClass() {
        System.out.print("Enter class name to add: ");
        String className = input.next();
        selectDayAdd(className);
    }

    // MODIFIES: this
    // EFFECTS: removes a class from a particular day in the schedule
    private void removeClass() {
        System.out.print("Enter class name to remove: ");
        String className = input.next();
        selectDayRemove(className);
    }

    // EFFECTS: prompts user to select which day of the week
    private void selectDayAdd(String className) {
        String selection = "";  // force entry into loop

        while (!(selection.equals("Monday") || selection.equals("Tuesday") || selection.equals("Wednesday")
                || selection.equals("Thursday") || selection.equals("Friday"))) {
            System.out.println("Monday");
            System.out.println("Tuesday");
            System.out.println("Wednesday");
            System.out.println("Thursday");
            System.out.println("Friday");
            selection = input.next();
        }

        if (selection.equals("Monday")) {
            mySchedule.addClassMonday(className);
        } else if (selection.equals("Tuesday")) {
            mySchedule.addClassTuesday(className);
        } else if (selection.equals("Wednesday")) {
            mySchedule.addClassWednesday(className);
        } else if (selection.equals("Thursday")) {
            mySchedule.addClassThursday(className);
        } else {
            mySchedule.addClassFriday(className);
        }
        printSchedule(mySchedule);
    }

    private void selectDayRemove(String className) {
        String selection = "";  // force entry into loop

        while (!(selection.equals("Monday") || selection.equals("Tuesday") || selection.equals("Wednesday")
                || selection.equals("Thursday") || selection.equals("Friday"))) {
            System.out.println("Monday");
            System.out.println("Tuesday");
            System.out.println("Wednesday");
            System.out.println("Thursday");
            System.out.println("Friday");
            selection = input.next();
        }

        if (selection.equals("Monday")) {
            mySchedule.removeClassMonday(className);
        } else if (selection.equals("Tuesday")) {
            mySchedule.removeClassTuesday(className);
        } else if (selection.equals("Wednesday")) {
            mySchedule.removeClassWednesday(className);
        } else if (selection.equals("Thursday")) {
            mySchedule.removeClassThursday(className);
        } else {
            mySchedule.removeClassFriday(className);
        }
        printSchedule(mySchedule);
    }

    // EFFECTS: prints current schedule to the screen
    private String printSchedule(WeeklyClasses selected) {
        System.out.printf("Schedule: \n %s", selected.toString());
        return selected.toString();
    }
}

