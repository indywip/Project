package persistence;

import model.WeeklyClasses;
import org.junit.jupiter.api.Test;
import persistence.JsonReader;
import persistence.JsonWriter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonWriterTest extends JsonTest {
    //NOTE TO CPSC 210 STUDENTS: the strategy in designing tests for the JsonWriter is to
    //write data to a file and then use the reader to read it back in and check that we
    //read in a copy of what was written out.

    @Test
    void testWriterInvalidFile() {
        try {
            WeeklyClasses wc = new WeeklyClasses("My schedule");
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testWriterEmptySchedule() {
        try {
            WeeklyClasses wc = new WeeklyClasses("My schedule");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptySchedule.json");
            writer.open();
            writer.write(wc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptySchedule.json");
            wc = reader.read();
            assertEquals("My schedule", wc.getName());
            assertEquals("Monday: []\n" +
                    " Tuesday: []\n" +
                    " Wednesday: []\n" +
                    " Thursday: []\n" +
                    " Friday: []", wc.getSchedule());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralSchedule() {
        try {
            WeeklyClasses wc = new WeeklyClasses("My schedule");
            wc.addClass("CPSC110", "Monday");
            wc.addClass("CPSC121", "Tuesday");
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralSchedule.json");
            writer.open();
            writer.write(wc);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralSchedule.json");
            wc = reader.read();
            assertEquals("My schedule", wc.getName());
            assertEquals("Monday: [CPSC110]\n" +
                    " Tuesday: [CPSC121]\n" +
                    " Wednesday: []\n" +
                    " Thursday: []\n" +
                    " Friday: []", wc.getSchedule());
            // List<Thingy> thingies = wc.getThingies();
            // assertEquals(2, thingies.size());
            checkClass("CPSC11O", wc.getDay("Monday").get(0));
            // checkClass("needle", Category.STITCHING, thingies.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
