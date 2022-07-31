public class Output {
    public String task1 = "Wake up";
    private String task2 = "Gimnastic";
    private String task3 = "Daily meeting";
    private String task4 = "Eat";
    String task5;

public void fullOutput()
    {
        System.out.println("Your Kanban board now:");
        urgentOutput();
        highOutput();
        mediumOutput();
        lowOutput();
    }
    public void urgentOutput()
    {

        System.out.println("Task number 1: " + task1);
    }
    public void highOutput()
    {

        System.out.println("Task number 2: " + task2);
    }
    public void mediumOutput()
    {
        System.out.println("Task number 3: " + task3);

    }
    public void lowOutput()
    {

        System.out.println("Task number 4: " + task4);
    }
}
