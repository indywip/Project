package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WeeklyClassesTest {
    private WeeklyClasses testSchedule;

    @BeforeEach
    void runBefore() {
        testSchedule = new WeeklyClasses("Indy");
    }

    @Test
    void testConstructor() {
        assertEquals("Indy", testSchedule.getName());
    }


    @Test
    void testRetrieveDay() {
        testSchedule.addClass("CPSC110", "Monday");
        assertEquals("CPSC110", testSchedule.getDay("Monday").get(0).retrieveClass());
    }

    @Test
    void testPrintMonday() {
        testSchedule.addClass("CPSC110", "Monday");
        assertEquals("Monday: [CPSC110]", testSchedule.mondayToString());
    }

    @Test
    void testPrintTuesday() {
        testSchedule.addClass("CPSC110", "Tuesday");
        assertEquals("Tuesday: [CPSC110]", testSchedule.tuesdayToString());
    }

    @Test
    void testPrintWednesday() {
        testSchedule.addClass("CPSC110", "Wednesday");
        assertEquals("Wednesday: [CPSC110]", testSchedule.wednesdayToString());
    }

    @Test
    void testPrintThursday() {
        testSchedule.addClass("CPSC110", "Thursday");
        assertEquals("Thursday: [CPSC110]", testSchedule.thursdayToString());
    }

    @Test
    void testPrintFriday() {
        testSchedule.addClass("CPSC110", "Friday");
        assertEquals("Friday: [CPSC110]", testSchedule.fridayToString());
    }

    @Test
    void testAddClass() {
        testSchedule.addClass("CPSC110", "Monday");
        assertEquals("Monday: [CPSC110]\n" +
                "Tuesday: []\n" +
                "Wednesday: []\n" +
                "Thursday: []\n" +
                "Friday: []", testSchedule.getSchedule());
    }

    @Test
    void testRemoveClassEmpty() {
        testSchedule.removeClass("CPSC110","Tuesday");
        assertEquals("Monday: []\n" +
                "Tuesday: []\n" +
                "Wednesday: []\n" +
                "Thursday: []\n" +
                "Friday: []", testSchedule.getSchedule());
    }

    @Test
    void testRemoveClass() {
        testSchedule.addClass("CPSC110", "Thursday");
        testSchedule.removeClass("CPSC110","Thursday");
        assertEquals("Monday: []\n" +
                "Tuesday: []\n" +
                "Wednesday: []\n" +
                "Thursday: []\n" +
                "Friday: []", testSchedule.getSchedule());
    }

    @Test
    void testAddMultipleClasses() {
        testSchedule.addClass("CPSC110", "Wednesday");
        testSchedule.addClass("CPSC121", "Wednesday");
        assertEquals("Monday: []\n" +
                "Tuesday: []\n" +
                "Wednesday: [CPSC110, CPSC121]\n" +
                "Thursday: []\n" +
                "Friday: []", testSchedule.getSchedule());
    }

    @Test
    void testRemoveMultipleClasses() {
        testSchedule.addClass("CPSC110", "Friday");
        testSchedule.addClass("CPSC121", "Friday");
        testSchedule.removeClass("CPSC110","Friday");
        testSchedule.removeClass("CPSC121","Friday");
        assertEquals("Monday: []\n" +
                "Tuesday: []\n" +
                "Wednesday: []\n" +
                "Thursday: []\n" +
                "Friday: []", testSchedule.getSchedule());
    }
}
