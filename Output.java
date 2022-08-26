public class Output {
    public String task1 = "Wake up";
    private String task2 = "Gimnastic";
    private String task3 = "Daily meeting";
    private String task4 = "Eat";

    void printTitle(){

        //System.out.println("Your Kanban board now is:");
    }

public void fullOutput()
    {
        urgentOutput();
        highOutput();
        mediumOutput();
        lowOutput();
    }


    public void urgentOutput()
    {
        printTitle();
        System.out.println(task1);
    }
    public void highOutput()
    {
        printTitle();
        System.out.println(task2);
    }
    public void mediumOutput()
    {
        System.out.println(task3);
    }
    public void lowOutput()
    {
        printTitle();
        System.out.println(task4);
    }

}
