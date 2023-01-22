import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import java.util.UUID;

public class IO {

    String[] ContentArray = new String[5];

    public static String[] readTaskContent() {
        String path = Options.setTaskPath();
        File FileForTasks = new File(path);
        Scanner ContentReader = null;
        try {
            ContentReader = new Scanner(FileForTasks);

            String tasksLine = ContentReader.nextLine();
            String[] oneTask = tasksLine.split(", ");
            ContentReader.close();
            return oneTask;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static int[] readTaskNumber() throws FileNotFoundException, ParseException {
        String ion = Options.setNumberFilename();
        String path = String.format("C:\\Development\\%s", ion);
        File FileForNumbers = new File(path);
        Scanner NumbersReader = new Scanner(FileForNumbers);
        String numbersLine = NumbersReader.nextLine();
        String[] oneNumber = numbersLine.split(" ");
        int[] numbersN = new int[oneNumber.length];
        int numbersCounter = 0;
        for (String number : oneNumber) {
            numbersN[numbersCounter++] = Integer.parseInt(number);
        }
        NumbersReader.close();
        return numbersN;
    }
    public static UUID[] readTaskUUID() throws IOException {
        String iou = Options.setUUIDFilename();
        String path = String.format("C:\\Development\\%s", iou);
        File FileForUUIDs = new File(path);
        FileReader FFUReader = new FileReader(FileForUUIDs);
        BufferedReader ffuBR = new BufferedReader(FFUReader, 5);
        int UUIDCounter = 0;
        String[] UUIDstring = ffuBR.readLine().split(", ");
        UUID[] NativeUUIDs = new UUID[UUIDstring.length];
        ffuBR.close();
        FFUReader.close();
        for (String UUID : UUIDstring) {
            NativeUUIDs[UUIDCounter++] = java.util.UUID.fromString(UUIDstring[UUIDCounter - 1]);
        }
        return NativeUUIDs;
    }

    public static int[] readTaskPriority() throws FileNotFoundException, ParseException {
        String iop = Options.setPriorityFilename();
        String path = String.format(iop);
        File FileForPriorities = new File(path);
        Scanner PriorityReader = new Scanner(FileForPriorities);
        String priorityLine = PriorityReader.nextLine();
        String[] onePriority = priorityLine.split(",");
        int[] prioritiesN = new int[onePriority.length];
        int prioritiesCounter = 0;
        for (String priority : onePriority) {
            prioritiesN[prioritiesCounter++] = Integer.parseInt(priority);

        }
        PriorityReader.close();
        return prioritiesN;
    }

    public static void writeTask(Task tsk1) {
Task tsk = new Task(25, 2,"dssd");
        try {
            FileOutputStream wrTask = new FileOutputStream(Options.taskName());
            ObjectOutputStream wrTas = new ObjectOutputStream(wrTask);
            wrTas.writeObject(tsk);
            wrTas.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //return tsk1;
    }

    public static Object readTask() throws IOException, ClassNotFoundException {
//        String iota = Options.taskName();
//        String path = String.format(iota);
        Task printedTask = new Task();
        try {
            FileInputStream reTask = new FileInputStream(Options.taskName());
            ObjectInputStream reTas = new ObjectInputStream(reTask);
            printedTask = (Task) reTas.readObject();
//            System.out.println("Entered task: ");
//            System.out.println(printedTask.toString());
reTas.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        //return printedTask;
        return null;
    }
}