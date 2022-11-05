import org.apache.kafka.common.protocol.types.Field;

public class Options {

    String absPath = "C:\\Development\\";

    public static String setNumberFilename() {
        String Number = "numbers.cpd";
        return Number;
    }
    public static String setTaskPath() {
        String Content = "tasks.cpd";
        String contentPath = String.format("C:\\Development\\%s", Content);
        return contentPath;
    }
    public static String setPriorityFilename() {
        String Priority = "priorities.cpd";
        return Priority;
    }
    public static String setUUIDFilename() {
        String UUID = "uuids.cpd";
        return UUID;
    }
}
