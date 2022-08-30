import java.io.File;
import java.io.IOException;

public class IO {

        String IOS;
        String ios;

        public static String setIOtasks (){
            String ios;
            File FileForTasks = new File("C:\\Development\\tasks.txt");
            ios = FileForTasks.toString();
            System.out.println("Save file path: " + ios);
            if (FileForTasks.exists()) {
                System.out.println("File already exists");
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


    public String getIOS (String IOS) {
            IOS = ios;
            return IOS;
        }

        public void getIOtasks () {
            System.out.println();
        }

        public void printFilename () {
            System.out.println(ios);
        }

    }
