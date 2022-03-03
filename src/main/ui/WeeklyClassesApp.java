package ui;

import model.WeeklyClasses;
import persistence.JsonWriter;
import persistence.JsonReader;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

// Student classes per week application
public class WeeklyClassesApp {
    private WeeklyClasses mySchedule;
    private static final String JSON_STORE = "./data/schedule.json";
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: runs the weekly classes application
    public WeeklyClassesApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        mySchedule = new WeeklyClasses("Joe's schedule");
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
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

            if (command.equals("6")) {
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
        switch (command) {
            case "1":
                addClass();
                break;
            case "2":
                removeClass();
                break;
            case "3":
                printSchedule(mySchedule);
                break;
            case "4":
                saveSchedule();
                break;

            case "5":
                loadSchedule();
                break;
            default:
                System.out.println("Invalid selection");
        }
    }

    // MODIFIES: this
    // EFFECTS: initializes schedule
    private void init() {
        mySchedule = new WeeklyClasses("Joe's schedule");
        input = new Scanner(System.in);
        input.useDelimiter("\n");
    }

    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect number from:");
        System.out.println("\t1. Add a class");
        System.out.println("\t2. Remove a class");
        System.out.println("\t3. View current schedule");
        System.out.println("\t4. Save schedule to file");
        System.out.println("\t5. Load schedule from file");
        System.out.println("\t6. Complete");
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
        String selection = ""; // force entry into loop

        while (!(selection.equals("Monday") || selection.equals("Tuesday") || selection.equals("Wednesday")
                || selection.equals("Thursday") || selection.equals("Friday"))) {
            System.out.println("Monday");
            System.out.println("Tuesday");
            System.out.println("Wednesday");
            System.out.println("Thursday");
            System.out.println("Friday");
            selection = input.next();
        }
        mySchedule.addClass(className, selection);
        printSchedule(mySchedule);
    }

    private void selectDayRemove(String className) {
        String selection = "";  // force entry into loop

        while (!(selection.equals("Monday") || selection.equals("Tuesday") || selection.equals("Wednesday")
                || selection.equals("Thursday") || selection.equals("Friday"))) {
            System.out.println("Monday\nTuesday\nWednesday\nThursday\nFriday");
            selection = input.next();
        }

        switch (selection) {
            case "Monday":
                mySchedule.removeClassMonday(className);
                break;
            case "Tuesday":
                mySchedule.removeClassTuesday(className);
                break;
            case "Wednesday":
                mySchedule.removeClassWednesday(className);
                break;
            case "Thursday":
                mySchedule.removeClassThursday(className);
                break;
            default:
                mySchedule.removeClassFriday(className);
        }
        printSchedule(mySchedule);
    }

    // EFFECTS: prints current schedule to the screen
    private String printSchedule(WeeklyClasses selected) {
        System.out.printf("Schedule: \n %s", selected.toString());
        return selected.toString();
    }

    private void saveSchedule() {
        try {
            jsonWriter.open();
            jsonWriter.write(mySchedule);
            jsonWriter.close();
            System.out.println("Saved " + mySchedule.getName() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads weekly classes from file
    private void loadSchedule() {
        try {
            mySchedule = jsonReader.read();
            System.out.println("Loaded " + mySchedule.getName() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}

