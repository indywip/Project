package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
    void testAddClass() {
        testSchedule.addClassMonday("CPSC110");
        assertEquals("[ Monday: [CPSC110]\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

    //ArrayList<String> = new ArrayList<>();
    //ArrayList<ArrayList<String>> schedule = new ArrayList<>();
    //testSchedule = new WeeklyClasses();
    // testSchedule.name ="Indy";

    @Test
    void testRemoveClassEmpty() {
        testSchedule.removeClassTuesday("CPSC110");
        assertEquals("[ Monday: []\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

    @Test
    void testRemoveClass() {
        testSchedule.addClassThursday("CPSC110");
        testSchedule.removeClassThursday("CPSC110");
        assertEquals("[ Monday: []\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

    @Test
    void testAddMultipleClasses() {
        testSchedule.addClassWednesday("CPSC 110");
        testSchedule.addClassWednesday("CPSC 121");
        assertEquals("[ Monday: []\n" +
                " Tuesday: [CPSC110, CPSC121]\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

    @Test
    void testRemoveMultipleClasses() {
        testSchedule.addClassTuesday("CPSC 110");
        testSchedule.addClassTuesday("CPSC 121");
        testSchedule.removeClassFriday("CPSC 110");
        testSchedule.removeClassFriday("CPSC 121");
        assertEquals("[ Monday: []\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }
}
