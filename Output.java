public class Output {
    public final String task1 = "Wake up";
    private final String task2 = "Daily meeting";
    private final String task4 = "Eat";

    void printTitle(){

        //System.out.println("Your Kanban board now is:");
    }
public void fullOutput()
    {
        urgentOutput();
        highOutput();
        lowOutput();
    }
    public void urgentOutput()
    {
        System.out.println(task1);
    }
    public void highOutput()
    {
        printTitle();
        System.out.println(task2);
    }

    public void lowOutput()
    {
        printTitle();
        System.out.println(task4);
    }

    public static void printNames() {
        System.out.println("File name for numbers: " + Options.setNumberFilename());
        System.out.println("File name for tasks: " + Options.setTaskFilename());
        System.out.println("File name for priorities: " + Options.setPriorityFilename());
        System.out.println("File name for UUIDs: " + Options.setUUIDFilename());
    }

}
