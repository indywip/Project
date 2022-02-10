package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    private WeeklyClasses testSchedule;

    @BeforeEach
    void runBefore() {
        testSchedule = new WeeklyClasses("Indy", "\nMonday:" "\nTuesday:" "\nWednesday:"
                "\nThursday:" "\nFriday:");
    }

    @Test
    void testConstructor() {
        assertEquals("Indy", testSchedule.getName());
        assertEquals("Indy", "\nMonday:" "\nTuesday:" "\nWednesday:" "\nThursday:" "\nFriday:",
                testSchedule.getSchedule());
    }

    @Test
    void testAddClass() {
        testSchedule.addClass("CPSC110");
        assertEquals("CPSC110", testSchedule.getSchedule());
    }

    @Test
    void testRemoveClass() {
        testSchedule.removeClass("CPSC110");
        assertEquals("CPSC110", testSchedule.getSchedule());
    }

    @Test
    void testAddMultipleClasses() {
        testSchedule.addClass("CPSC 110");
        testSchedule.addClass("CPSC 121");
        assertEquals("CPSC 110" "CPSC 121", testSchedule.getSchedule());
    }

    @Test
    void testRemoveMultipleClasses() {
        testSchedule.removeClass("CPSC 110");
        testSchedule.removeClass("CPSC 121");
        assertEquals("CPSC 110" "CPSC 121", testSchedule.getSchedule());
    }
