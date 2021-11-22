package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//taken from Alarm System Project
public class EventTest {
    private Event e;
    private Date d;
    private Date eDate;

    //NOTE: these tests might fail if time at which line (2) below is executed
    //is different from time that line (1) is executed.  Lines (1) and (2) must
    //run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        e = new Event("Sensor open at door");
        eDate = e.getDate(); // (1)
        d = Calendar.getInstance().getTime();   // (2)
    }

//    @Test
//    public void testEvent() {
//        assertEquals("Sensor open at door", e.getDescription());
//        Duration dur = Duration.between(eDate, d);
//        assertTrue(difference < 0.1);
//    }

    @Test
    public void testToString() {
        assertEquals(d.toString() + "\n" + "Sensor open at door", e.toString());
    }
}
