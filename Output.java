public class Output {

public void fullOutput()
    {
        highOutput();
    }
    public void highOutput()
    {
        String task2 = "Daily meeting";
        System.out.println(task2);
    }
    public static void printPaths() {
        System.out.println("File name for numbers: " + Options.setNumberFilename());
        System.out.println("File name for tasks: " + Options.setTaskPath());
        System.out.println("File name for priorities: " + Options.setPriorityFilename());
        System.out.println("File name for UUIDs: " + Options.setUUIDFilename());
        System.out.println("File name for added task: " + Options.taskName());
    }

}