import java.util.Scanner;
import java.util.UUID;

public class Task {

public String contentV;
byte priorityV;
    UUID uuid1;
    UUID[] uuidArray;
    int number = 1;
    public Task (int number, UUID uuid1, int priority, String content, boolean active) {
       // for (int i = 1; i < uuidArray.length; i++) {
//            this.uuid1=UUID.randomUUID();
//            uuidArray[number]=this.uuid1;
      //  }
        this.uuid1=UUID.randomUUID();
        //uuidArray[number]=this.uuid1;
    }
    public Task (int priority, String content)
    {
        setContent(contentV);
        setPriority(priorityV);
        this.uuid1 = UUID.randomUUID();

    };
    public Task (String content)
    {
        setContent(contentV);
        //uuid = new UUID();
    }
    public Task(){
    };

    public void outputAdded(){
        System.out.println(this.getContent(contentV));

    }
    public String getContent(String contnt) {
contnt = contentV;
    return contnt;
}
public void setContent (String content) {
    Scanner writeContent = new Scanner(System.in);
    System.out.println("Please enter task content.");
    contentV = writeContent.nextLine();
}
public int getPriority (byte prrty) {
prrty=priorityV;
        return prrty;
}
public void setPriority (byte priority) {
    Scanner writePriority = new Scanner(System.in);
    System.out.println("Enter task priority");
    System.out.println("0 - Urgent\n1 - High\n2 - Medium\n3 - Low");
    priorityV = writePriority.nextByte();
    }
    public void printTask(){

        //System.out.println(this.getContent(contentV)+this.getPriority(priorityV));
        StringBuilder prnt = new StringBuilder();
        prnt.append(this.getContent(contentV)).append(" with priority ").append(this.getPriority(priorityV));
        System.out.println(prnt);
        System.out.println(this.uuid1);
    }
//    void returnUUID() {
//        uuidArray[number]=this.uuid1;
//    }
 }
