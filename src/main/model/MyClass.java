package model;

import org.json.JSONObject;
import persistence.Writable;

// Represents a single class
public class MyClass implements Writable {
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

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("classname", classname);
        return json;
    }
}

