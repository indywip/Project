package ui;

import model.WeeklyClasses;
import java.util.Scanner;

// Student classes per week application
public class WeeklyClassesApp {
    private WeeklyClasses Monday;
    private WeeklyClasses Tuesday;
    private WeeklyClasses Wednesday;
    private WeeklyClasses Thursday;
    private WeeklyClasses Friday;
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

            if (command.equals("Done")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("\nComplete");
    }
}


    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("Add a class")) {
            addClass();
        } else if (command.equals("Remove a class")) {
            removeClass();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes schedule
    private void init() {
        Monday = new WeeklyClasses("Joe", 145.00);
        Tuesday = new WeeklyClasses("Joe", 256.50);
        Wednesday = new WeeklyClasses("Joe", 145.00);
        Thursday = new WeeklyClasses("Joe", 256.50);
        Friday = new WeeklyClasses("Joe", 145.00);
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\tAdd a class");
        System.out.println("\tRemove a class");
        System.out.println("\tComplete");
    }

    // MODIFIES: this
    // EFFECTS: adds a class to a particular day in the schedule
    private void addClass() {
        WeeklyClasses selected = selectDay();
        System.out.print("Enter class name to add: ");

        printSchedule(selected);
    }

    // MODIFIES: this
    // EFFECTS: removes a class from a particular day in the schedule
    private void removeClass() {
        WeeklyClasses selected = selectDay();
        System.out.print("Enter class name to remove: ");

        printSchedule(selected);
    }

    // EFFECTS: prompts user to select which day of the week
    // else if (selection.equals("Tuesday")) {
    //            return Tuesday;
    //        }else if (selection.equals("Tuesday")) {
    //            return Tuesday;
    //        } and returns it
    private WeeklyClasses selectDay() {
        String selection = "";  // force entry into loop

        while (!(selection.equals("Monday") || selection.equals("Tuesday") || selection.equals("Wednesday") ||
                selection.equals("Thursday") || selection.equals("Friday"))) {
            System.out.println("Monday");
            System.out.println("Tuesday");
            System.out.println("Wednesday");
            System.out.println("Thursday");
            System.out.println("Friday");
            selection = input.next();
            selection = selection.toLowerCase();
        }

        if (selection.equals("Monday")) {
            return Monday;
        } else if (selection.equals("Tuesday")) {
            return Tuesday;
        } else if (selection.equals("Wednesday")) {
            return Wednesday;
        } else if (selection.equals("Thursday")) {
            return Thursday;
        } else {
            return Friday;
        }
    }

    // EFFECTS: prints current schedule to the screen
    private void printSchedule(WeeklyClasses selected) {
        System.out.printf("Balance: $%.2f\n", selected.getSchedule());
    }
}
