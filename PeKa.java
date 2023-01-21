
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;
import static java.util.UUID.randomUUID;

public class PeKa {

    String path = Options.setTaskPath();

    private static int[] Priorities;

    static {
        try {
            Priorities = IO.readTaskPriority();
        } catch (IOException | ParseException ep) {
            throw new RuntimeException(ep);
        }
    }

    private static UUID[] UUIDs;

    static {
        try {
            UUIDs = IO.readTaskUUID();
        } catch (IOException eu) {
            throw new RuntimeException(eu);
        }
    }

    private final static int[] Numbers;

    static {
        try {
            Numbers = IO.readTaskNumber();
        } catch (FileNotFoundException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String[] Tasks;

    static {
        Tasks = IO.readTaskContent();
    }

    private final static Logger Loger = Logger.getLogger("Inform");

    public static void main(String[] args) throws FileNotFoundException {
        Output presettledOutput = new Output();
        String u;
        int exxit;
        int taskCount = 1;
        String mode;

        Task testFile = new Task(1, UUIDs[1], 2, "", true);
        Task testAdd = new Task(0, randomUUID(), 3, "", true);
        Task Add1 = new Task(0, randomUUID(), 3, "", true);
        // Task Add2 = new Task(0, randomUUID(), 3, "", true);
        Task[] ForAdd = new Task[taskCount + 1];


        System.out.println("Current time: " + LocalDateTime.now().format(DateTimeFormatter.ISO_TIME));

        Scanner enterTask = new Scanner(System.in);
        System.out.println("Wanna enter new task(s)?");
        mode = enterTask.nextLine();
        if (mode.equals("y")) {
            Scanner tskCnt = new Scanner(System.in);
            System.out.println("How many tasks will you add?");
            taskCount = tskCnt.nextInt();
            if (taskCount < 4) {
                Loger.info(taskCount + " tasks will add to your kanban panel");
            } else
                Loger.warning("Too many tasks!!!11");

            if (taskCount == 1) {
                ForAdd[0] = testAdd;
                ForAdd[0].addTask();
//                try {
//                    FileOutputStream wrTask = new FileOutputStream(Options.taskName());
//                    ObjectOutputStream wrTas = new ObjectOutputStream(wrTask);
//                    wrTas.writeObject(testAdd);
//                    wrTas.close();
//                } catch (FileNotFoundException e) {
//                    throw new RuntimeException(e);
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
                IO.writeTask(testAdd);
            } else if (taskCount == 2) {
                ForAdd[0] = testAdd;
                ForAdd[0].addTask();
                ForAdd[1] = Add1;
                ForAdd[1].addTask();
            } else {

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
                            System.out.println("Nothing to output");
                        }
                        case "a" -> {
                            presettledOutput.fullOutput();
                            for (int i = 0; i < taskCount; i++) {
                            }
                            IO.readTaskContent();
                        }
                        case "u" -> {
                            System.out.println("Your task(s) with urgent priority:");
                            presettledOutput.urgentOutput();
                            if (testAdd.priorityV == 0) {
                                for (int i = 0; i < taskCount; i++) {
                                }
                            }
                        }
                        case "h" -> {
                            System.out.println("Your high priority task(s):");
                            presettledOutput.highOutput();
                            if (ForAdd[taskCount - 1].priorityV == 1) { //ToDo fix array size error
                                for (int i = 0; i < taskCount; i++) {
                                    //   ForAdd[i].printTaskName();
                                }
                            }
                        }
                        case "m" -> {
                            System.out.println("Your medium priority task(s):");
                            if (testAdd.priorityV == 2) {
                                testAdd.printTaskName();
                            }
                            System.out.println("Task number " + Numbers[testFile.number] + " : " + Tasks[testFile.number] + " with UUID = " + UUIDs[testFile.number] + " and priority " + Priorities[testFile.number]);
                        }
                        case "l" -> {
                            System.out.println("Your low priority task(s):");
                            presettledOutput.lowOutput();
                            if (testAdd.priorityV == 3) {
                                testAdd.printTaskName();
                            }
                        }
                        case "s" -> {
                            for (int i = 0; i < taskCount; i++) {
                                Output.printPaths();
                            }
                        }
                        case "Test" -> {
                            System.out.println("All tasks: " + Arrays.toString(Tasks));
                            System.out.println("All numbers: " + Arrays.toString(Numbers));
                            System.out.println(Arrays.toString(UUIDs));
                            System.out.println("All priorities: " + Arrays.toString(Priorities));
                        }
                        default -> {
                            System.err.println("Unknown priority");
                            Loger.warning("Please try again");
                        }
                    }
                    System.out.println("Press 0 for exit, any another digit for continue.");
                    exxit = exit.nextInt();
                } while (exxit != 0);
            }

        }
    }
}
