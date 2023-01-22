public class Output {
    public final String task1 = "Wake up";

public void fullOutput()
    {
        urgentOutput();
        highOutput();
    }
    public void urgentOutput()
    {
        System.out.println(task1);
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