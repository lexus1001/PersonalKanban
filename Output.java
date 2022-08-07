public class Output {
    public String task1 = "Wake up";
    private String task2 = "Gimnastic";
    private String task3 = "Daily meeting";
    private String task4 = "Eat";
    String task5;

    void printTitle(){

        System.out.println("Your Kanban board now is:");
    }

public void fullOutput()
    {
        urgentOutput();
        highOutput();
        mediumOutput();
        lowOutput();
    }

    public void setTask5(String task5) {
        this.task5 = task5;
    }

    public String getTask5() {
        return task5;
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
