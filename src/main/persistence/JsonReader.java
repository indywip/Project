package persistence;

import model.WeeklyClasses;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Represents a reader that reads schedule from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads schedule from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WeeklyClasses read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseSchedule(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses schedule from JSON object and returns it
    private WeeklyClasses parseSchedule(JSONObject jsonObject) {
        String name = jsonObject.getString("Name");
        WeeklyClasses wc = new WeeklyClasses(name);
        addDays(wc, jsonObject);
        return wc;
    }

    // MODIFIES: wc
    // EFFECTS: parses thingies from JSON object and adds them to schedule
    private void addDays(WeeklyClasses wc, JSONObject jsonObject) {
        JSONArray jsonMonday = jsonObject.getJSONArray("Monday");
        for (Object json : jsonMonday) {
            JSONObject nextClass = (JSONObject) json;
            addJsonClass("Monday", wc, nextClass);
        }

        JSONArray jsonTuesday = jsonObject.getJSONArray("Tuesday");
        for (Object json : jsonTuesday) {
            JSONObject nextClass = (JSONObject) json;
            addJsonClass("Tuesday", wc, nextClass);
        }

        JSONArray jsonWednesday = jsonObject.getJSONArray("Wednesday");
        for (Object json : jsonWednesday) {
            JSONObject nextClass = (JSONObject) json;
            addJsonClass("Wednesday", wc, nextClass);
        }

        JSONArray jsonThursday = jsonObject.getJSONArray("Thursday");
        for (Object json : jsonThursday) {
            JSONObject nextClass = (JSONObject) json;
            addJsonClass("Thursday", wc, nextClass);
        }

        JSONArray jsonFriday = jsonObject.getJSONArray("Friday");
        for (Object json : jsonFriday) {
            JSONObject nextClass = (JSONObject) json;
            addJsonClass("Friday", wc, nextClass);
        }
    }

    // MODIFIES: wc
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addJsonClass(String day, WeeklyClasses wc, JSONObject jsonObject) {
        String name = jsonObject.getString("classname");
        wc.addClass(name, day);
    }
}

