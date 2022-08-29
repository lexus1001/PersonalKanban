import java.io.File;
import java.io.IOException;

public class IO {

        String IOS;
        String ios;

        public static void setIOtasks (String ios){

            File FileForTasks = new File("C:\\Development\\tasks.txt");
            if (FileForTasks.exists()) {
                System.out.println("File already exists");
            } else {
                try {
                    FileForTasks.createNewFile();
                } catch (IOException e) {
                    System.out.println("Creation error");
                    e.printStackTrace();
                    ios = FileForTasks.toString();
                    // throw new RuntimeException(e);
                }
            }
        }

        public String getIOS () {
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
