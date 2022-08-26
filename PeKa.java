import java.awt.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;

import static java.util.UUID.nameUUIDFromBytes;
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
        int stopAdd;

        Task techTask = new Task();
        Task testAdd = new Task(0,randomUUID(),3,"",true);
        //Task[] ForAdd = new Task[5];
        Task task5 = new Task (2,"Yggdrasil");

       do {
           Scanner scanStopAdd = new Scanner(System.in);
           testAdd.addTask();
           System.out.println("Press 5 for exit, any another digit for continue.");
           stopAdd = scanStopAdd.nextInt();
       } while (stopAdd!=5);

        tt = testAdd.getContent(testAdd.contentV);//for test
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
                    testAdd.printTaskFullInfo();
                    //task5.printTask();
                    if (tt.length()<2) {
                        Loger.warning("Too short task description"); //ToDo Test this
                    }
                }
                case "a" -> {
                    presettledOutput.fullOutput();
                    testAdd.printTaskName();
                    task5.printTaskName();
                }
                case "u" -> {
                    System.out.println("Your task(s) with urgent priority:");
                    presettledOutput.urgentOutput();
                    if (testAdd.priorityV == 0) {
                       testAdd.printTaskName();
                    }}
                case "h" -> {
                System.out.println("Your high priority task(s):");
                presettledOutput.highOutput();
                    if (testAdd.priorityV == 1) {
                        testAdd.printTaskFullInfo();
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
                    testAdd.printAllUUIDs();
                    //task5.printAllUUIDs();
                }
                case  "Test" -> {
                    testAdd.printAllContent();
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
