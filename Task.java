import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.UUID;

public class Task {

public String contentV;
String[] ContentArray = new String[5];
byte priorityV;
    UUID[] uuidArray = new UUID[4];
    UUID uuid;
    int number;
    int numberV;

    public Task (int number, UUID uuid2, int priority, String content, boolean active) {
    }
    public Task (int priority, String content)
    {};
    public Task (String content)
    {
        setContent(contentV);
    }
    public Task(){
    };

    public void addTask() {
        setContent(contentV);
        setPriority(priorityV);
        setNumber(numberV);
        setUuid(uuid);
    }
    public int getNumber() {
        number = numberV;
        return number;
    }
    public void setNumber(int number) {
        Scanner numScan = new Scanner(System.in);
        System.out.println("Enter number for new task");
        numberV = numScan.nextInt();
    }

    public void setUuid(UUID uuid1) {
        uuidArray[number] = UUID.randomUUID();
            this.uuid = uuidArray[this.number];
        }

    public UUID getUuid(UUID uuid2) {
        return uuid2;
    }
public void setContent (String content) {
    Scanner writeContent = new Scanner(System.in);
    System.out.println("Please enter task content.");
    ContentArray[number] = writeContent.nextLine();
    this.contentV = ContentArray[this.number];
    //IO.setIOtasks(Options.setTaskPath());
    PrintWriter pwTasks = null;
        try {
            pwTasks = new PrintWriter(Options.setTaskPath());
            pwTasks.println(writeContent.nextLine());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        pwTasks.close();
    }
    public String getContent(String contnt) {
        contnt = contentV;
        return contnt;
    }
public void setPriority (byte priority) {
    Scanner writePriority = new Scanner(System.in);
    System.out.println("Enter task priority");
    System.out.println("0 - Urgent\n1 - High\n2 - Medium\n3 - Low");
    priorityV = writePriority.nextByte();
    }
    public int getPriority (byte prrty) {
       prrty = priorityV;
        return prrty;
    }
    public void printTaskFullInfo(){
        StringBuilder prnt = new StringBuilder();
        prnt.append("Task number ").append(this.getNumber()).append(" ").append(this.getContent(contentV)).append(" with priority ").append(this.getPriority(priorityV));
        System.out.println(prnt);
        System.out.println("Tasks UUID: " + getUuid(this.uuid));
    }
    public void printTaskName() {
        System.out.println(this.getContent(contentV));
    }

 }
