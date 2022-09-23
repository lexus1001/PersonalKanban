import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static java.util.UUID.randomUUID;

public class PeKa {

    static int[] Numbers;

    static {
        try {
            Numbers = IO.readTaskNumber();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    static String[] Tasks;

    static {
        try {
            Tasks = IO.readTaskContent();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

   private static Logger Loger = Logger.getLogger("Inform");
   LogRecord logRecordInfo = new LogRecord(Level.INFO,"All Ok"); //LogRecord xprmnt

    public PeKa() throws FileNotFoundException {
    }

    public static void main (String[] args) throws FileNotFoundException {
        Output presettledOutput = new Output();
        String u;
        String tt;
        int exxit;
        int taskCount;

        System.out.println("Current time: " + LocalDateTime.now());
        IO.setIOtasks();
IO.setIOUIIDs();

        System.out.println(Arrays.toString(Tasks));
        System.out.println(Arrays.toString(Numbers));

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
        Task[] ForAdd = new Task[taskCount];

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
                    IO.readTaskContent();
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
                    if (testAdd.priorityV == 2) {
                        testAdd.printTaskName();
                    }
                    System.out.println("Task number " + Numbers[testAdd.number] + " : " + Tasks[testAdd.number]);
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
                        Output.printNames();
                    }
                }
                case  "Test" -> {
                    IO.readTaskContent();
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
