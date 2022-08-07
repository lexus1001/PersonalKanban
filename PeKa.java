import java.awt.*;
import java.util.Scanner;
import java.util.UUID;
import static java.util.UUID.randomUUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.LogRecord;
import static java.awt.Color.*;


public class PeKa {

   private static Logger Loger = Logger.getLogger("Inform");
   LogRecord logRecordInfo = new LogRecord(Level.INFO,"All Ok"); //LogRecord xprmnt
   LogRecord logRecordWarn = new LogRecord(Level.WARNING,"Not All OK!");
   //Color infC = new Color(255,50,0);
    //int []numbers={1,2,3,4,5,6,7,8,9};

    public static void main (String[] args) {
        Output presettledOutput = new Output();
        String u;
        String tt;
        Task testAdd = new Task(1,randomUUID(),1,"Nobody",true);
        Task task5 = new Task (2,"Yggdrasil");
       testAdd.setContent(testAdd.contentV);
       testAdd.setPriority(testAdd.priorityV);
        tt = testAdd.getContent(testAdd.contentV);//for test
        Loger.info("Added successfully");

        //System.out.println(yellow.getBlue()); color xprmnt

        Scanner exit = new Scanner(System.in);
        int exxit;
        do {
            System.out.println("Please enter priority first letter: ");
            System.out.println("u - Urgent\nh - High\nm - Medium\nl - Low\nt - Recently added task");
            System.out.println("or a for all.\nAny another button for statistic.");
            Scanner priorScan = new Scanner(System.in);
            u = priorScan.nextLine();

            switch (u) {
                case "t" -> {
                    testAdd.printTask();
                    task5.printTask();
                    if (tt.length()<2) {
                        Loger.warning("Too short task description");
                    }
                }
                case "a" -> {
                    presettledOutput.fullOutput();
                    testAdd.printTask();
                    task5.printTask();
                }
                case "u" -> {
                    System.out.println("Your task(s) with urgent priority:");
                    presettledOutput.urgentOutput();
                    if (testAdd.priorityV == 0) {
                       testAdd.outputAdded();
                    }}
                case "h" -> {
                System.out.println("Your high priority task(s):");
                presettledOutput.highOutput();
                    if (testAdd.priorityV == 1) {
                        testAdd.printTask();
                    }}
                case "m" -> {
                    System.out.println("Your medium priority task(s):");
                    presettledOutput.mediumOutput();
                    if (testAdd.priorityV == 2) {
                        testAdd.outputAdded();
                    }
                }
                case "l" -> {
                    System.out.println("Your low priority task(s):");
                    presettledOutput.lowOutput();
                    if (testAdd.priorityV == 3) {
                        testAdd.outputAdded();
                    }}
                default ->
                        Loger.warning("Unknown priority");
                   }
            System.out.println("Press 0 for exit, any another digit for continue.");
            exxit = exit.nextInt();
        } while(exxit!=0);
    }
    }
