
import java.util.Scanner;
import static java.util.UUID.randomUUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogRecord;

public class PeKa {

   private static Logger Loger = Logger.getLogger("Inform");
   LogRecord logRecordInfo = new LogRecord(Level.INFO,"All Ok"); //LogRecord xprmnt
   LogRecord logRecordWarn = new LogRecord(Level.WARNING,"Not All OK!");

    public static void main (String[] args) {
        Output presettledOutput = new Output();
        String u;
        String tt;
        int exxit;
        int taskCount;

IO.setIOtasks();

        Scanner tskCnt = new Scanner(System.in);
        System.out.println("How many tasks will you add?");
        taskCount = tskCnt.nextInt();
      if (taskCount<4) {
          Loger.info(taskCount + " tasks will add to your kanban panel");
      } else
          Loger.warning("Too many tasks!!!11");

        //Task techTask = new Task();
        Task testAdd = new Task(0,randomUUID(),3,"",true);
        Task Add1 = new Task(0,randomUUID(),3,"",true);
        Task Add2 = new Task(0,randomUUID(),3,"",true);
        Task Add3 = new Task(0,randomUUID(),3,"",true);
        Task Add4 = new Task(0,randomUUID(),3,"",true);
        Task[] ForAdd = new Task[taskCount];
        Task task5 = new Task (2,"Yggdrasil");

        if (taskCount==1) {
            ForAdd[0] = testAdd;
            ForAdd[0].addTask();
        } else if (taskCount ==2) {
            ForAdd[0] = testAdd;
            ForAdd[0].addTask();
            ForAdd[1] = Add1;
            ForAdd[1].addTask();
        } else if (taskCount==3) {
            ForAdd[0] = testAdd;
            ForAdd[0].addTask();
            ForAdd[1] = Add1;
            ForAdd[1].addTask();
            ForAdd[2] = Add2;
            ForAdd[2].addTask();
        }

        tt = ForAdd[taskCount-1].getContent(testAdd.contentV);//for test
        Loger.info("Added successfully");

        Scanner exit = new Scanner(System.in);

        do {
            System.out.println("Please enter priority first letter: ");
            System.out.println("u - Urgent\nh - High\nm - Medium\nl - Low\nt - Recently added task");
            System.out.println("or a for all.\nType 's' button for statistic.");
            Scanner priorScan = new Scanner(System.in);
            u = priorScan.nextLine();

            switch (u) {
                case "t" -> {
                    for (int i = 0; i < taskCount; i++) {
                        ForAdd[i].printTaskFullInfo();
                    }
                    //task5.printTask();
                    if (tt.length()<2) {
                        Loger.warning("Too short task description"); //ToDo Test this
                    }
                }
                case "a" -> {
                    presettledOutput.fullOutput();
                    for (int i = 0; i < taskCount; i++) {
                        ForAdd[i].printTaskName();
                    }
                    //task5.printTaskName();
                }
                case "u" -> {
                    System.out.println("Your task(s) with urgent priority:");
                    presettledOutput.urgentOutput();
                    if (testAdd.priorityV == 0) {
                        for (int i = 0; i < taskCount; i++) {
                            ForAdd[i].printTaskName();
                        }
                    }}
                case "h" -> {
                System.out.println("Your high priority task(s):");
                presettledOutput.highOutput();
                    if (ForAdd[taskCount-1].priorityV == 1) { //ToDo fix array size error
                        for (int i = 0; i < taskCount; i++) {
                            ForAdd[i].printTaskName();
                        }
                    }}
                case "m" -> {
                    System.out.println("Your medium priority task(s):");
                    presettledOutput.mediumOutput();
                    if (testAdd.priorityV == 2) {
                        testAdd.printTaskName();
                    }
                }
                case "l" -> {
                    System.out.println("Your low priority task(s):");
                    presettledOutput.lowOutput();
                    if (testAdd.priorityV == 3) {
                        testAdd.printTaskName();
                    }}
                case "s" -> {
                    for (int i = 0; i < taskCount; i++) {
                        ForAdd[i].printAllUUIDs();
                    }
                    //ForAdd[taskCount].printAllUUIDs(); //ToDo Fix UUID output
                    //task5.printAllUUIDs();
                }
                case  "Test" -> {
                    for (int i = 0; i < taskCount; i++) {
                        ForAdd[i].printAllContent(); //ToDo Doesn't work
                    }
                }
                default -> {
                    System.err.println("Unknown priority");
                    Loger.warning("Please try again");
                }
                   }
            System.out.println("Press 0 for exit, any another digit for continue.");
            exxit = exit.nextInt();
        } while(exxit!=0);
    }
    }
