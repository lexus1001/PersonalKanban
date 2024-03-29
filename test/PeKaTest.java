import org.testng.*;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.internal.reflect.MethodMatcherException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.UUID;
import java.util.regex.Matcher;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNotNull;
import static org.hamcrest.Matcher.*;

public class PeKaTest {

    private static int[] Priorities;
    private static UUID testUUID = UUID.randomUUID();
    private static String testTask = "rgbjlf";
    private static int testNumber = 2;
    private String input;

    static {
        try {
            Priorities = IO.readTaskPriority();
        } catch (IOException | ParseException ep) {
            throw new RuntimeException(ep);
        }
    }

    private static UUID[] UUIDs;

    static {
        try {
            UUIDs = IO.readTaskUUID();
        } catch (IOException eu) {
            throw new RuntimeException(eu);
        }
    }

    private static int[] Numbers;

    static {
        try {
            Numbers = IO.readTaskNumber();
        } catch (FileNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private static String[] Tasks;

    static {
        Tasks = IO.readTaskContent();
    }

    @Test(description = "Test arrays parsing from content file", priority = 0, successPercentage = 97, testName = "Test content file reading")
    public void TaskArrayTest() {
        input = Tasks[0];
        Assert.assertEquals(input, testTask, "random message");

        assertNotEquals(Tasks[2], null);
        assertNotNull(Priorities);
    }

    @Test(description = "Test arrays parsing from UUID file", priority = 1, timeOut = 3255, testName = "Test UUID file reading")
    public void UUIDArrayTest() {
        assertNotEquals(UUIDs[2], null, "UUIDs file not null");
    }

    @Test(description = "Test arrays parsing from priority file", priority = 1, testName = "Test Priority file reading", alwaysRun = true)
    public void PriorityArrayTest() {
        assertNotNull(Priorities, "Priorities not null");
    }

    @Test(description = "Test from data provider", dataProvider = "Files",
    expectedExceptions = org.testng.TestException.class, expectedExceptionsMessageRegExp = "No digit")
    public void summaryTest(String input, String expected) {
        String result = input;
        Assert.assertEquals(result, expected, "random message" + expected);
        org.hamcrest.Matchers.contains(0);
        AssertJUnit.assertEquals("Test success!!!", result, expected);

    }

    @DataProvider(name = "Files")
    public Object[][] testObj() {
        return new Object[][]{
                {Tasks[0], testTask},
                {UUIDs[0].toString(), testUUID.toString()},
                {Numbers[0], testNumber},
                {Priorities[0], 2}
        };
    }

}