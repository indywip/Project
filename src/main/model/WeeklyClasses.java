package model;

import java.util.ArrayList;
import java.util.List;

// Represents an account having an  owner name and weekly class schedule
public class WeeklyClasses {
    private String name;                   // the account owner name
    // private ArrayList<ArrayList<classname>> schedule;
    private ArrayList<String> monday;
    private ArrayList<String> tuesday;
    private ArrayList<String> wednesday;
    private ArrayList<String> thursday;
    private ArrayList<String> friday;


    // the current class schedule

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName;
     *          initialSchedule is empty and only lists the days of the week;
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

    // initialSchedule.add("Monday:");
    // initialSchedule.add("Tuesday:");
    // initialSchedule.add("Wednesday:");
    // initialSchedule.add("Thursday:");
    // initialSchedule.add("Friday:");
    // initialSchedule = "\nMonday:" "\nTuesday:" "\nWednesday:" "\nThursday:" "\nFriday:" {

    public String getName() {
        return name;
    }

    // public String getSchedule() {
    //     return schedule;
    // }


    /*
     * REQUIRES: class is String
     * MODIFIES: this
     * EFFECTS: class is added to schedule and updated schedule is returned
     */
    public void addClassMonday(String myClass) {
        monday.add(myClass);
        return;
    }

    public void addClassTuesday(String myClass) {
        tuesday.add(myClass);
        return;
    }

    public void addClassWednesday(String myClass) {
        wednesday.add(myClass);
        return;
    }

    public void addClassThursday(String myClass) {
        thursday.add(myClass);
        return;
    }

    public void addClassFriday(String myClass) {
        friday.add(myClass);
        return;
    }

    /*
     * REQUIRES: class is String and class is found in getSchedule()
     * MODIFIES: this
     * EFFECTS: class is removed from schedule and updated schedule is returned
     */
    public void removeClassMonday(String myClass) {
        monday.remove(myClass);
        return;
    }

    public void removeClassTuesday(String myClass) {
        tuesday.remove(myClass);
        return;
    }

    public void removeClassWednesday(String myClass) {
        wednesday.remove(myClass);
        return;
    }

    public void removeClassThursday(String myClass) {
        thursday.remove(myClass);
        return;
    }

    public void removeClassFriday(String myClass) {
        friday.remove(myClass);
        return;
    }

    //List<String> schedule = new ArrayList<>();
    //        schedule = schedule.remove(class);

    /*
     * EFFECTS: returns a string representation of schedule
     */
   @Override
   public String toString() {
       return "[ Monday: " + monday.toString() + "\n Tuesday: " + tuesday.toString() +
               "\n Wednesday: " + wednesday.toString() + "\n Thursday: " + thursday.toString() +
               "\n Friday: " + friday.toString() + "]";
     }
}




