package model;

import java.util.ArrayList;
import java.util.List;

// Represents an account having an  owner name and weekly class schedule
public class WeeklyClasses {
    private String name;                   // the account owner name
    private String schedule;                // the current class schedule

    /*
     * REQUIRES: accountName has a non-zero length
     * EFFECTS: name on account is set to accountName;
     *          initialSchedule is empty and only lists the days of the week;
     */
    public WeeklyClasses(String accountName, String initialSchedule {
        name = accountName;
        initialSchedule = "\nMonday:" "\nTuesday:" "\nWednesday:" "\nThursday:" "\nFriday:" {
            schedule = initialSchedule;
        }
    }

    public String getName() {
        return name;
    }

    public String getSchedule() {
        return schedule;
    }

    /*
     * REQUIRES: class is String
     * MODIFIES: this
     * EFFECTS: class is added to schedule and updated schedule is returned
     */
    public String addClass(String class) {
        List<String> schedule = new ArrayList<>();
        schedule = schedule.add(class);
        return schedule;
    }

    /*
     * REQUIRES: class is String and class is found in getSchedule()
     * MODIFIES: this
     * EFFECTS: class is removed from schedule and updated schedule is returned
     */
    public String removeClass(String class) {
        List<String> schedule = new ArrayList<>();
        schedule = schedule.remove(class);
        return schedule;
    }

    /*
     * EFFECTS: returns a string representation of schedule
     */
    @Override
    public String toString() {
        String balanceStr = String.format("%.2f", schedule);  // get balance to 2 decimal places as a string
        // return "[ id = " + id + ", name = " + name + ", "+ "balance = $" + balanceStr + "]";
        return "[ Monday = " + class + ", Tuesday = " + class + ", Wednesday = " + class + ",
                Thursday = " + class + ", Friday = " + class + "]";
    }
}
