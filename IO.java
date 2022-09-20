import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.FileTime;

public class IO {

    String IOS;
    String ios;

    public static String setIOtasks() {
        String ios;
        File FileForTasks = new File("C:\\Development\\tasks.txt");
        ios = FileForTasks.getName();
        System.out.println("Save file path for tasks: " + ios);

        if (FileForTasks.exists()) {
            System.out.println("File already exists in " + FileForTasks.getPath());
        } else {
            try {
                FileForTasks.createNewFile();
            } catch (IOException e) {
                System.out.println("Creation error");
                e.printStackTrace();
                // throw new RuntimeException(e);
            }
        }
        return ios;
    }

    public static String setIOUIIDs() {
        String ios2;
        FileTime uuidFileTime = null;
        File FileForUUIDs = new File("UUIDs.txt");
        ios2 = String.valueOf(FileForUUIDs);
        System.out.println("UUIDs is saved in " + ios2);
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
        return ios2;
    }


    public String getIOS(String IOS) {
        this.IOS = ios;
        return IOS;
    }
}