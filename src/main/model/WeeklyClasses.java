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

    public String getName() {
        return name;
    }

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
        } else if (inputDay.equals("Tuesday")) {
            tuesday.add(classClass);
        } else if (inputDay.equals("Wednesday")) {
            wednesday.add(classClass);
        } else if (inputDay.equals("Thursday")) {
            thursday.add(classClass);
        } else {
            friday.add(classClass);
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
    }

    public void removeClassTuesday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        tuesday.removeIf(condition);
    }

    public void removeClassWednesday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        wednesday.removeIf(condition);
    }

    public void removeClassThursday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        thursday.removeIf(condition);
    }

    public void removeClassFriday(String inputClass) {
        Predicate<MyClass> condition = theclass -> theclass.retrieveClass().equals(inputClass);
        friday.removeIf(condition);
    }

    /*
     * EFFECTS: returns a string representation of schedule
     */
    @Override
    public String toString() {
        ArrayList<String> mondayStrings = new ArrayList<>();
        for (MyClass days : monday) {
            mondayStrings.add(days.retrieveClass());
        }

        ArrayList<String> tuesdayStrings = new ArrayList<>();
        for (MyClass days : tuesday) {
            tuesdayStrings.add(days.retrieveClass());
        }

        ArrayList<String> wednesdayStrings = new ArrayList<>();
        for (MyClass days : wednesday) {
            wednesdayStrings.add(days.retrieveClass());
        }

        ArrayList<String> thursdayStrings = new ArrayList<>();
        for (MyClass days : thursday) {
            thursdayStrings.add(days.retrieveClass());
        }

        ArrayList<String> fridayStrings = new ArrayList<>();
        for (MyClass days : friday) {
            fridayStrings.add(days.retrieveClass());
        }

        return "Monday: " + mondayStrings + "\n Tuesday: " + tuesdayStrings + "\n Wednesday: " + wednesdayStrings
                + "\n Thursday: " + thursdayStrings + "\n Friday: " + fridayStrings;
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


