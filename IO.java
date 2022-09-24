import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.text.ParseException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class IO {

    String[] ContentArray = new String[5];




    public static void setIOtasks() {
        String iot = Options.setTaskFilename();
        String path = String.format("C:\\Development\\%s", iot);
        File FileForTasks = new File(path);
        if (FileForTasks.exists()) {
            System.out.println("File already exists in " + FileForTasks.getPath());
        } else {
            try {
                FileForTasks.createNewFile();
            } catch (IOException e) {
                System.out.println("Creation error");
                e.printStackTrace();
            }
        }
    }

    public static void setIOUIIDs() {
        String iou = Options.setUUIDFilename();
        String path = String.format("C:\\Development\\%s", iou);
        FileTime uuidFileTime = null;
        File FileForUUIDs = new File(path);
        String iou2 = String.valueOf(FileForUUIDs);
        System.out.println("Path for uuids file: " + iou2);
        if (FileForUUIDs.exists()) {
            try {
                uuidFileTime = Files.getLastModifiedTime(FileForUUIDs.toPath(), new java.nio.file.LinkOption[]{});
            } catch (IOException LMT) {
                LMT.printStackTrace();
            }
            System.out.println(String.format("File for UUIDs already exists on path " + FileForUUIDs.getAbsoluteFile() + " and last modificate " + uuidFileTime));
        }
        else {
            try {
                FileForUUIDs.createNewFile();
            } catch (IOException u) {
                u.printStackTrace();
            }
        }
    }

    public static String[] readTaskContent () throws FileNotFoundException {
        String iot = Options.setTaskFilename();
        String path = String.format("C:\\Development\\%s", iot);
        File FileForTasks = new File(path);
            Scanner ContentReader = new Scanner(FileForTasks);
            String tasksLine = ContentReader.nextLine();
            String[] oneTask = tasksLine.split(", ");
            ContentReader.close();

        return oneTask;
    }

    public static int[] readTaskNumber () throws FileNotFoundException, ParseException {
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
    return numbersN ;
    }

    public static UUID[] readTaskUUID() throws IOException {
        String oneUUID;
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
            NativeUUIDs[UUIDCounter++] = java.util.UUID.fromString(UUIDstring[UUIDCounter-1]);
            System.out.println(NativeUUIDs);
        }
        return NativeUUIDs;
    }

    public static int[] readTaskPriority () throws FileNotFoundException, ParseException {
        String iop = Options.setPriorityFilename();
        String path = String.format("C:\\Development\\%s", iop);
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
        return prioritiesN ;
    }

}