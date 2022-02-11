package ui;

import model.WeeklyClasses;
import java.util.Scanner;

// Student classes per week application
public class WeeklyClassesApp {
    private WeeklyClasses MySchedule;
    private Scanner input;
    private String myClass;

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
            System.out.println("Invalid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes schedule
    private void init() {
        MySchedule = new WeeklyClasses("Joe");
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
        System.out.print("Enter class name/s to add: ");
        String myClass = input.nextLine();
        MySchedule = selectDayAdd();

        printSchedule(MySchedule);
    }

    // MODIFIES: this
    // EFFECTS: removes a class from a particular day in the schedule
    private void removeClass() {
        System.out.print("Enter class name/s to remove: ");
        String myClass = input.nextLine();
        MySchedule = selectDayRemove();

        printSchedule(MySchedule);
    }

    // EFFECTS: prompts user to select which day of the week
    private WeeklyClasses selectDayAdd() {
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
            model.WeeklyClasses.addClassMonday(myClass);
        } else if (selection.equals("Tuesday")) {
            model.WeeklyClasses.addClassTuesday(myClass);
        } else if (selection.equals("Wednesday")) {
            model.WeeklyClasses.addClassWednesday(myClass);
        } else if (selection.equals("Thursday")) {
            model.WeeklyClasses.addClassThursday(myClass);
        } else {
            model.WeeklyClasses.addClassFriday(myClass);
        }
    }

    private WeeklyClasses selectDayRemove() {
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
            model.WeeklyClasses.removeClassMonday(myClass);
        } else if (selection.equals("Tuesday")) {
            model.WeeklyClasses.removeClassTuesday(myClass);
        } else if (selection.equals("Wednesday")) {
            model.WeeklyClasses.removeClassWednesday(myClass);
        } else if (selection.equals("Thursday")) {
            model.WeeklyClasses.removeClassThursday(myClass);
        } else {
            model.WeeklyClasses.removeClassFriday(myClass);
        }
    }

    // EFFECTS: prints current schedule to the screen
    private void printSchedule(WeeklyClasses selected) {
    System.out.println("Schedule: \n",selected.toString())
        }
    }
}
   // System.out.printf("Balance: $%.2f\n", selected.getSchedule());
