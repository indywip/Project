package model;

import java.util.ArrayList;
import java.util.List;

// Represents an account having an  owner name and weekly class schedule
public class WeeklyClasses {
    private String name;                   // the account owner name
    // private ArrayList<ArrayList<classname>> schedule;
    private String myClass;
    private ArrayList<myClass> monday;
    private ArrayList<myClass> tuesday;
    private ArrayList<myClass> wednesday;
    private ArrayList<myClass> thursday;
    private ArrayList<myClass> friday;


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

    public String getClass() {
        myClass = new String;
        return myClass;
    }

    /*
     * REQUIRES: class is String
     * MODIFIES: this
     * EFFECTS: class is added to schedule and updated schedule is returned
     */
    public String addClassMonday(String myClass) {
        monday = monday.add(myClass);
        return;
    }

    public String addClassTuesday(String myClass) {
        tuesday = tuesday.add(myClass);
        return;
    }

    public String addClassWednesday(String myClass) {
        wednesday = wednesday.add(myClass);
        return;
    }

    public String addClassThursday(String myClass) {
        thursday = thursday.add(myClass);
        return;
    }

    public String addClassFriday(String myClass) {
        friday = friday.add(myClass);
        return;
    }

    /*
     * REQUIRES: class is String and class is found in getSchedule()
     * MODIFIES: this
     * EFFECTS: class is removed from schedule and updated schedule is returned
     */
    public String removeClassMonday(String myClass) {
        monday = monday.remove(myClass);
        return;
    }

    public String removeClassTuesday(String myClass) {
        tuesday = tuesday.remove(myClass);
        return;
    }

    public String removeClassWednesday(String myClass) {
        wednesday = wednesday.remove(myClass);
        return;
    }

    public String removeClassThursday(String myClass) {
        thursday = thursday.remove(myClass);
        return;
    }

    public String removeClassFriday(String myClass) {
        friday = friday.remove(myClass);
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




