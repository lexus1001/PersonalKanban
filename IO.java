import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;
import java.util.Scanner;

public class IO {


    public static void setIOtasks() {
        String iot = Options.setTaskFilename();
        String path = String.format("C:\\Development\\%s", iot);
        File FileForTasks = new File(path);
        //ios = FileForTasks.getName();
    //public static void createContentFile() {
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
            } catch (Exception LMT) {
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

    public static void readTaskContent () {
        String iot = Options.setTaskFilename();
        String path = String.format("C:\\Development\\%s", iot);
        File FileForTasks = new File(path);
        try {
            Scanner ContentReader = new Scanner(FileForTasks);
            while (ContentReader.hasNextLine()) {
                System.out.println(ContentReader.nextLine());
            }
        } catch (FileNotFoundException fff) {
            fff.printStackTrace();
        }
    }

    public static void readTaskNumber () {

    }
}