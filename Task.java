import java.util.Scanner;
import java.util.UUID;

public class Task {

public String contentV;
byte priorityV;
    UUID[] uuidArray = new UUID[4];
    UUID uuid;
    int number;
    int numberV;

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

    public void setUUIDforOld() {
        for (number = 0; number < uuidArray.length; number++) {
            uuidArray[number] = UUID.randomUUID();
        }
    }
    public void setUuid(UUID uuid1) {
        uuidArray[number] = UUID.randomUUID();
            this.uuid = uuidArray[this.number];
        }
//        UUID uuid = uuidArray[uid];
//        this.uuid1=UUID.randomUUID();
    public UUID getUuid(UUID uuid2) {
        return uuid2;
    }

    public Task (int number, UUID uuid2, int priority, String content, boolean active) {
//        for (int i = 1; i < uuidArray.length; i++) {
//            uuidArray[i]=UUID.randomUUID();
//            uuidArray[number]=this.uuid1;
//
    }
    public Task (int priority, String content)
    {
    };
    public Task (String content)
    {
        setContent(contentV);
    }
    public Task(){
    };

public void setContent (String content) {
    Scanner writeContent = new Scanner(System.in);
    System.out.println("Please enter task content.");
    contentV = writeContent.nextLine();
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

    public void printAllUUIDs() {
        System.out.println("All tasks UUIDs: \n");
        for (number = 0; number < uuidArray.length; number++) {
            if (this.uuid != null) {
                System.out.println(uuidArray[number] + " (task #" + this.numberV + ")");
                break;
            }{
            }
        }
        System.out.println("Maximum count of tasks with UUID = " + uuidArray.length);
    }
 }
