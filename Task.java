import java.util.Scanner;

public class Task {

String contentV;

    public Task (int number,int priority, String content, boolean active) {

    }
    public Task (String content) {
        setContent(contentV);
    }
    public Task(){};

public String getContent(String contnt) {
        return contnt;
}
public void setContent (String content) {
    Scanner writeContent = new Scanner(System.in);
    System.out.println("Please enter task content.");
    contentV = writeContent.nextLine();

        //this.contentV=content;
}
}
