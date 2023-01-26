public class Options {

    static String absPath = "C:\\Development\\";
    static  StringBuilder path = new StringBuilder(absPath);

    public static String setNumberFilename() {
        return "numbers.cpd";
    }

    public static String setTaskPath() {
        String Content = "tasks.cpd";
        return String.format("C:\\Development\\%s", Content);
    }

    public static String setPriorityFilename() {
        String Priority;
        Priority = String.valueOf(path.append("priorities.cpd"));//ToDo Упростить, понять почему ошибки при упрощении
        return Priority;
    }

    public static String setUUIDFilename() {
        return "uuids.cpd";
    }

    public static String taskName() {
        return "Task1.ddd";
    }
}