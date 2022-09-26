import org.testng.Assert;
import org.testng.annotations.*;
//import static org.hamcrest.Matchers.*;
//import static asserters.Matcher.assertThatWithWait;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;
import java.util.UUID;

import static org.testng.Assert.*;

public class PeKaTest {

    static int[] Priorities;

    static {
        try {
            Priorities = IO.readTaskPriority();
        } catch (IOException | ParseException ep) {
            throw new RuntimeException(ep);
        }
    }

    static UUID[] UUIDs;

    static {
        try {
            UUIDs = IO.readTaskUUID();
        } catch (IOException eu) {
            throw new RuntimeException(eu);
        }
    }

    static int[] Numbers;

    static {
        try {
            Numbers = IO.readTaskNumber();
        } catch (FileNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    static String[] Tasks;

    static {
        try {
            Tasks = IO.readTaskContent();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(description = "Test arrays parsing from content file", priority = 0, successPercentage = 97, testName = "Test content file reading")
    private void TaskArrayTest() {
Tasks[2]="5";
        Assert.assertEquals(Tasks[2], "67ohfu2houi");

        assertNotEquals(UUIDs[2], null);
        assertNotNull(Priorities);
    }

    @Test (testName = "Test numbers file reading")
    private void NumberArrayTest() {
        assertEquals(Numbers[2], 13);
    }

    @Test(description = "Test arrays parsing from UUID file", priority = 1, timeOut = 3255, testName = "Test UUID file reading")
    private void UUIDArrayTest() {
        assertNotEquals(UUIDs[2], null);
    }

    @Test(description = "Test arrays parsing from priority file", priority = 1,testName = "Test Priority file reading", alwaysRun = true)
    private void PriorityArrayTest() {
        assertNotNull(Priorities);
    }

}