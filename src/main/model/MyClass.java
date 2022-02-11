package model;

// Represents a single class
public class MyClass {
    private String classname; // the class name

    public MyClass() {
    }

    public String retrieveClass() {
        return classname;
    }

    /*
     * REQUIRES: myClassName is String
     * EFFECTS: populates the name of the class
     */
    public void setClass(String myClassName) {
        classname = myClassName;
    }
}

