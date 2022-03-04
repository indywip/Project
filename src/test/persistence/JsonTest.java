package persistence;

import model.MyClass;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonTest {
    protected void checkClass(String name, MyClass aClass) {
        assertEquals(name, aClass.retrieveClass());
    }
}
