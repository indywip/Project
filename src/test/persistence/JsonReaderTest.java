package persistence;

import model.WeeklyClasses;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            WeeklyClasses wc = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptySchedule() {
        JsonReader reader = new JsonReader("./data/testReaderEmptySchedule.json");
        try {
            WeeklyClasses wc = reader.read();
            assertEquals("My schedule", wc.getName());
            assertEquals("Monday: []\n" +
                    " Tuesday: []\n" +
                    " Wednesday: []\n" +
                    " Thursday: []\n" +
                    " Friday: []", wc.getSchedule());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralSchedule() {

        try {
            WeeklyClasses wc = new WeeklyClasses("My schedule");
            wc.addClass("CPSC110", "Monday");
            wc.addClass("CPSC121", "Tuesday");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSchedule.json");
            writer.open();
            writer.write(wc);
            writer.close();
            JsonReader reader = new JsonReader("./data/testReaderGeneralSchedule.json");
            wc = reader.read();
            assertEquals("My schedule", wc.getName());
            assertEquals("Monday: [CPSC110]\n" +
                    " Tuesday: [CPSC121]\n" +
                    " Wednesday: []\n" +
                    " Thursday: []\n" +
                    " Friday: []", wc.getSchedule());
            checkClass("CPSC11O", wc.getDay("Monday").get(0));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
