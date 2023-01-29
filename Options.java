public class Options {

    static String absPath = "C:\\Development\\";
    static  StringBuilder path = new StringBuilder(absPath);
    public static String[] eqOptFileNames() {
        String[] paths = IO.readOptionFile();
        return paths;
    }

    public static String setNumberFilename() {
        String[] paths = IO.readOptionFile();
        return paths[1];
    }

    public static String setTaskPath() {
        String[] paths = IO.readOptionFile();
        String Content = paths[2];
        return String.format("C:\\Development\\%s", Content);
    }

    public static String setPriorityFilename() {
        String[] paths = IO.readOptionFile();
        String Priority;
        Priority = String.valueOf(path.append(paths [3]));//ToDo Упростить, понять почему ошибки при упрощении
        return Priority;
    }

    public static String setUUIDFilename() {
        return "uuids.cpd";
    }

    public static String taskName() {
        String[] paths = eqOptFileNames();
        return paths[0];
    }
}