package persistence;

import model.MyClass;
import model.WeeklyClasses;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkClass(String name, MyClass classname) {
        assertEquals(name, classname.retrieveClass());
    }
}
