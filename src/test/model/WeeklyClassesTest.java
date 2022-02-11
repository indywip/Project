package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class AccountTest {
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
        ArrayList<String> monday = new ArrayList<>();
        ArrayList<ArrayList<String>> schedule = new ArrayList<>();
        assertEquals(schedule, testSchedule.getSchedule());
    }

    @Test
    void testRemoveClass() {
        testSchedule.removeClassThursday("CPSC110");
        ArrayList<String> monday = new ArrayList<>();
        ArrayList<ArrayList<String>> schedule = new ArrayList<>();
        assertEquals(schedule, testSchedule.getSchedule());
    }

    @Test
    void testAddMultipleClasses() {
        testSchedule.addClassTuesday("CPSC 110");
        testSchedule.addClassTuesday("CPSC 121");
        ArrayList<String> tuesday = new ArrayList<>();
        ArrayList<ArrayList<String>> schedule = new ArrayList<>();
        assertEquals(schedule, testSchedule.getSchedule());
    }

    @Test
    void testRemoveMultipleClasses() {
        testSchedule.removeClassWednesday("CPSC 110");
        testSchedule.removeClassWednesday("CPSC 121");
        ArrayList<String> wednesday = new ArrayList<>();
        ArrayList<ArrayList<String>> schedule = new ArrayList<>();
        assertEquals(schedule, testSchedule.getSchedule());
    }
