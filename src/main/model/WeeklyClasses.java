package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.function.Predicate;

// Represents an account having an owner name and weekly class schedule
public class WeeklyClasses implements Writable {
    private String name;                   // the account owner name
    private ArrayList<MyClass> monday;     // arraylist of daily classes
    private ArrayList<MyClass> tuesday;
    private ArrayList<MyClass> wednesday;
    private ArrayList<MyClass> thursday;
    private ArrayList<MyClass> friday;

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName;
     *          each arraylist is a day of the week and is initialized as empty;
     */
    public WeeklyClasses(String accountName) {
        name = accountName;
        monday = new ArrayList<>();
        tuesday = new ArrayList<>();
        wednesday = new ArrayList<>();
        thursday = new ArrayList<>();
        friday = new ArrayList<>();
    }


    /*
     * EFFECTS: returns account name of schedule owner
     */
    public String getName() {
        return name;
    }


    /*
     * EFFECTS: returns the array of a particular day in the week
     */
    public ArrayList<MyClass> getDay(String dayName) {
        if (dayName.equals("Monday")) {
            return monday;
        } else if (dayName.equals("Tuesday")) {
            return tuesday;
        } else if (dayName.equals("Wednesday")) {
            return wednesday;
        } else if (dayName.equals("Thursday")) {
            return thursday;
        } else {
            return friday;
        }
    }


    /*
     * EFFECTS: returns the schedule as a string
     */
    public String getSchedule() {
        return toString();
    }

    /*
     * REQUIRES: inputClass and inputDay are Strings
     * MODIFIES: this
     * EFFECTS: inputted class is added to inputted day of the week and updated schedule is returned
     */
    public void addClass(String inputClass, String inputDay) {
        MyClass classClass = new MyClass();
        classClass.setClass(inputClass);
        if (inputDay.equals("Monday")) {
            monday.add(classClass);
            EventLog.getInstance().logEvent(new Event("Class " + inputClass + " added to Monday"));
        } else if (inputDay.equals("Tuesday")) {
            tuesday.add(classClass);
            EventLog.getInstance().logEvent(new Event("Class " + inputClass + " added to Tuesday"));
        } else if (inputDay.equals("Wednesday")) {
            wednesday.add(classClass);
            EventLog.getInstance().logEvent(new Event("Class " + inputClass + " added to Wednesday"));
        } else if (inputDay.equals("Thursday")) {
            thursday.add(classClass);
            EventLog.getInstance().logEvent(new Event("Class " + inputClass + " added to Thursday"));
        } else {
            friday.add(classClass);
            EventLog.getInstance().logEvent(new Event("Class " + inputClass + " added to Friday"));
        }
    }

    /*
     * REQUIRES: inputClass is a String and is found in getSchedule()
     * MODIFIES: this
     * EFFECTS: class inputted is removed from day of the week and updated schedule is returned
     */
    public void removeClassMonday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        monday.removeIf(condition);
        EventLog.getInstance().logEvent(new Event("Class " + inputClass + " removed from Monday"));
    }

    public void removeClassTuesday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        tuesday.removeIf(condition);
        EventLog.getInstance().logEvent(new Event("Class " + inputClass + " removed from Tuesday"));
    }

    public void removeClassWednesday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        wednesday.removeIf(condition);
        EventLog.getInstance().logEvent(new Event("Class" + inputClass + " removed from Wednesday"));
    }

    public void removeClassThursday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        thursday.removeIf(condition);
        EventLog.getInstance().logEvent(new Event("Class " + inputClass + " removed from Thursday"));
    }

    public void removeClassFriday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        friday.removeIf(condition);
        EventLog.getInstance().logEvent(new Event("Class " + inputClass + " removed from Friday"));
    }

    /*
     * EFFECTS: returns a string representation of schedule
     */

    public String mondayToString() {
        ArrayList<String> mondayStrings = new ArrayList<>();
        for (MyClass days : monday) {
            mondayStrings.add(days.retrieveClass());
        }
        return "Monday: " + mondayStrings;
    }

    public String tuesdayToString() {
        ArrayList<String> tuesdayStrings = new ArrayList<>();
        for (MyClass days : tuesday) {
            tuesdayStrings.add(days.retrieveClass());
        }
        return "Tuesday: " + tuesdayStrings;
    }

    public String wednesdayToString() {
        ArrayList<String> wednesdayStrings = new ArrayList<>();
        for (MyClass days : wednesday) {
            wednesdayStrings.add(days.retrieveClass());
        }
        return "Wednesday: " + wednesdayStrings;
    }

    public String thursdayToString() {
        ArrayList<String> thursdayStrings = new ArrayList<>();
        for (MyClass days : thursday) {
            thursdayStrings.add(days.retrieveClass());
        }
        return "Thursday: " + thursdayStrings;
    }

    public String fridayToString() {
        ArrayList<String> fridayStrings = new ArrayList<>();
        for (MyClass days : friday) {
            fridayStrings.add(days.retrieveClass());
        }
        return "Friday: " + fridayStrings;
    }

    @Override
    public String toString() {
        return mondayToString() + "\n" + tuesdayToString() + "\n" + wednesdayToString() + "\n" + thursdayToString()
                + "\n" + fridayToString();
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("Name", name);
        json.put("Monday", mondayToJson());
        json.put("Tuesday", tuesdayToJson());
        json.put("Wednesday", wednesdayToJson());
        json.put("Thursday", thursdayToJson());
        json.put("Friday", fridayToJson());

        return json;
    }

    // EFFECTS: returns things in this schedule as a JSON array
    private JSONArray mondayToJson() {
        JSONArray jsonArray = new JSONArray();
        for (MyClass c : monday) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }

    private JSONArray tuesdayToJson() {
        JSONArray jsonArray = new JSONArray();
        for (MyClass c : tuesday) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }

    private JSONArray wednesdayToJson() {
        JSONArray jsonArray = new JSONArray();
        for (MyClass c : wednesday) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }

    private JSONArray thursdayToJson() {
        JSONArray jsonArray = new JSONArray();
        for (MyClass c : thursday) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }

    private JSONArray fridayToJson() {
        JSONArray jsonArray = new JSONArray();
        for (MyClass c : friday) {
            jsonArray.put(c.toJson());
        }
        return jsonArray;
    }
}


