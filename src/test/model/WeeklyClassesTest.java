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
        testSchedule.addClass("CPSC110", "Monday");
        assertEquals("[ Monday: [CPSC110]\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

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
        testSchedule.addClass("CPSC110", "Thursday");
        testSchedule.removeClassThursday("CPSC110");
        assertEquals("[ Monday: []\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

    @Test
    void testAddMultipleClasses() {
        testSchedule.addClass("CPSC 110", "Wednesday");
        testSchedule.addClass("CPSC 121", "Wednesday");
        assertEquals("[ Monday: []\n" +
                " Tuesday: []\n" +
                " Wednesday: [CPSC110, CPSC121]\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }

    @Test
    void testRemoveMultipleClasses() {
        testSchedule.addClass("CPSC 110", "Friday");
        testSchedule.addClass("CPSC 121", "Friday");
        testSchedule.removeClassFriday("CPSC 110");
        testSchedule.removeClassFriday("CPSC 121");
        assertEquals("[ Monday: []\n" +
                " Tuesday: []\n" +
                " Wednesday: []\n" +
                " Thursday: []\n" +
                " Friday: []]", testSchedule.getSchedule());
    }
}
