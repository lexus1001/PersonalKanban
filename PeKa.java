
import java.io.*;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;
import static java.util.UUID.randomUUID;

public class PeKa {

    private final static int[] Priorities;

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

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Output presettledOutput = new Output();
        String u;
        int exxit;
        int taskCount = 1;
        String mode;

        Task testFile = new Task(1, UUIDs[1], 2, "", true);
        Task testAdd = new Task(0, randomUUID(), 3, "", true);
        Task Add1 = new Task(0, randomUUID(), 3, "", true);
        Task shortTask = new Task(10,0,"Something");
        Task[] ForAdd = new Task[taskCount + 1];

        Scanner enterTask = new Scanner(System.in);
        System.out.println("Wanna enter new task(s)?");
        mode = enterTask.nextLine();
        if (mode.equals("y")) {
            Scanner tskCnt = new Scanner(System.in);
            System.out.println("How many tasks will you add?");
            taskCount = tskCnt.nextInt();

            if (taskCount == 1) {
                shortTask.addTask();
                //IO.writeTask(shortTask);
                try {
                    FileOutputStream wrTask = new FileOutputStream(Options.taskName());
                    ObjectOutputStream wrTas = new ObjectOutputStream(wrTask);
                    wrTas.writeObject(shortTask);
                    wrTas.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                    IO.readTask();
            } else if (taskCount == 2) {
                ForAdd[0] = testAdd;
                ForAdd[0].addTask();
                ForAdd[1] = Add1;
                ForAdd[1].addTask();
            }
        } else if (mode.equals("n")) {
                Scanner exit = new Scanner(System.in);

                do {
                    System.out.println("Please enter priority first letter: ");
                    System.out.println("h - High\nm - Medium\nt - Recently added task");
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
                        case "h" -> {
                            System.out.println("Your high priority task(s):");
                            presettledOutput.highOutput();
                            if (ForAdd[taskCount - 1].priorityV == 1) { //ToDo fix array size error
                                for (int i = 0; i < taskCount; i++) {
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
                        case "add" -> {
                            System.out.println("Serialized task");
                            try {
                                IO.readTask();
                                System.out.println(IO.readTask().priorityV);
                            } catch (IOException | ClassNotFoundException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println();
                        }
                        default -> {
                            System.err.println("Unknown priority");
                        }
                    }
                    System.out.println("Press 0 for exit, any another digit for continue.");
                    exxit = exit.nextInt();
                } while (exxit != 0);
            }
        }
    }