package model;

import java.util.ArrayList;
import java.util.List;

// Represents an account having an  owner name and weekly class schedule
public class WeeklyClasses {
    private String name;                   // the account owner name
    // private ArrayList<ArrayList<String>> schedule;
    private ArrayList<myClass> monday;
    private ArrayList<myClass> tuesday;
    private ArrayList<myClass> wednesday;
    private ArrayList<myClass> thursday;
    private ArrayList<myClass> friday;

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
    public void addClassMonday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        monday.add(classClass);
    }

    public void addClassTuesday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        tuesday.add(classClass);
    }

    public void addClassWednesday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        wednesday.add(classClass);
    }

    public void addClassThursday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        thursday.add(classClass);
    }

    public void addClassFriday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        friday.add(classClass);
    }

    /*
     * REQUIRES: class is String and class is found in getSchedule()
     * MODIFIES: this
     * EFFECTS: class is removed from day of the week and updated schedule is returned
     */
    public void removeClassMonday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        monday.remove(classClass);
    }

    public void removeClassTuesday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        tuesday.remove(classClass);
    }

    public void removeClassWednesday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        wednesday.remove(classClass);
    }

    public void removeClassThursday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        thursday.remove(classClass);
    }

    public void removeClassFriday(String inputClass) {
        myClass classClass = new myClass();
        classClass.setClass(inputClass);
        friday.remove(classClass);
    }

    @Override
    public String toString() {
        ArrayList<String> mondayStrings = new ArrayList<>();
        for (int i = 0; i < monday.size(); i++) {
            mondayStrings.add(monday.get(i).retrieveClass());
        }

        ArrayList<String> tuesdayStrings = new ArrayList<>();
        for (int i = 0; i < tuesday.size(); i++) {
            tuesdayStrings.add(tuesday.get(i).retrieveClass());
        }

        ArrayList<String> wednesdayStrings = new ArrayList<>();
        for (int i = 0; i < wednesday.size(); i++) {
            wednesdayStrings.add(wednesday.get(i).retrieveClass());
        }

        ArrayList<String> thursdayStrings = new ArrayList<>();
        for (int i = 0; i < thursday.size(); i++) {
            thursdayStrings.add(thursday.get(i).retrieveClass());
        }

        ArrayList<String> fridayStrings = new ArrayList<>();
        for (int i = 0; i < friday.size(); i++) {
            fridayStrings.add(friday.get(i).retrieveClass());
        }

        return "[ Monday: " + mondayStrings + "\n Tuesday: " + tuesdayStrings
                + "\n Wednesday: " + wednesdayStrings + "\n Thursday: " + thursdayStrings
                + "\n Friday: " + fridayStrings + "]";
    }
}

