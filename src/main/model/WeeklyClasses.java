package model;

import java.util.ArrayList;
import java.util.List;

// Represents an account having an  owner name and weekly class schedule
public class WeeklyClasses {
    private String name;                   // the account owner name
    private ArrayList<ArrayList<String>> schedule;
    private ArrayList<String> monday;
    private ArrayList<String> tuesday;
    private ArrayList<String> wednesday;
    private ArrayList<String> thursday;
    private ArrayList<String> friday;

    // the current class schedule

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName;
     *          each list is a day of the week and is initialized as empty;
     */
    public WeeklyClasses(String accountName) {
        // ArrayList<String> initialSchedule
        name = accountName;
        monday = new ArrayList<>();
        tuesday = new ArrayList<>();
        wednesday = new ArrayList<>();
        thursday = new ArrayList<>();
        friday = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return toString();
        //schedule = new ArrayList<>();
        //return schedule;
    }

    /*
     * REQUIRES: class is String
     * MODIFIES: this
     * EFFECTS: class is added to day of the week and updated schedule is returned
     */
    public void addClassMonday(String myClass) {
        monday.add(myClass);
    }

    public void addClassTuesday(String myClass) {
        tuesday.add(myClass);
    }

    public void addClassWednesday(String myClass) {
        wednesday.add(myClass);
    }

    public void addClassThursday(String myClass) {
        thursday.add(myClass);
    }

    public void addClassFriday(String myClass) {
        friday.add(myClass);
    }

    /*
     * REQUIRES: class is String and class is found in getSchedule()
     * MODIFIES: this
     * EFFECTS: class is removed from day of the week and updated schedule is returned
     */
    public void removeClassMonday(String myClass) {
        monday.remove(myClass);
    }

    public void removeClassTuesday(String myClass) {
        tuesday.remove(myClass);
    }

    public void removeClassWednesday(String myClass) {
        wednesday.remove(myClass);
    }

    public void removeClassThursday(String myClass) {
        thursday.remove(myClass);
    }

    public void removeClassFriday(String myClass) {
        friday.remove(myClass);
    }

    @Override
    public String toString() {
        return "[ Monday: " + monday.toString() + "\n Tuesday: " + tuesday.toString()
                + "\n Wednesday: " + wednesday.toString() + "\n Thursday: " + thursday.toString()
                + "\n Friday: " + friday.toString() + "]";
    }
}




