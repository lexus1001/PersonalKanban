
public class Options {

    public static String setNumberFilename() {
        String Number = "numbers.cpd";
        return Number;
    }
    public static String setTaskFilename() {
        String Content = "tasks.cpd";
        return Content;
    }
    public static String setPriorityFilename() {
        String Priority = "priorities.cpd";
        return Priority;
    }
    public static String setUUIDFilename() {
        String UUID = "uuids.cpd";
        return UUID;
    }

    public static void printNames() {
        System.out.println("File name for numbers: " + setNumberFilename());
        System.out.println("File name for tasks: " + setTaskFilename());
        System.out.println("File name for priorities: " + setPriorityFilename());
        System.out.println("File name for UUIDs: " + setUUIDFilename());
    }


}
