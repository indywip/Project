package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyClassTest {
    private MyClass testClasses;

    @BeforeEach
    void runBefore() {
        testClasses = new MyClass();
    }

    @Test
    void testConstructor() {
        testClasses.setClass("CPSC110");
        assertEquals("CPSC110", testClasses.retrieveClass());
    }

}