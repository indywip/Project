package model;

public class myClass {
    private String classname;

    public myClass(String myClassName) {
        classname = myClassName;
    }

    public String retrieveClass() {
        return classname;
    }

    public void setClass(String myClassName) {
        classname = myClassName;
    }
}

