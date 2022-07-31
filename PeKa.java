import java.util.Scanner;

public class PeKa {
    public static void main (String[] args) {
        Output presettledOutput = new Output();
        String u;
        String tt;
        Task testAdd = new Task();
       testAdd.setContent(testAdd.contentV);
       tt = testAdd.getContent(testAdd.contentV);

        Scanner exit = new Scanner(System.in);
        int exxit;
        do {

            System.out.println("Please enter priority first letter: ");
            System.out.println("u - Urgent\nh - High\nm - Medium\nl - low");
            System.out.println("or a for all.\nAny another button for statistic.");
            Scanner priorScan = new Scanner(System.in);
            u = priorScan.nextLine();

            switch (u) {
                case "t" -> System.out.println(tt);
                case "a" -> presettledOutput.fullOutput();
                case "u" -> {
                    System.out.println("Your task(s) with urgent priority:");
                    presettledOutput.urgentOutput();}
                case "h" -> {
                System.out.println("Your high priority task(s):");
                presettledOutput.highOutput();}
                case "m" -> {
                    System.out.println("Your medium priority task(s):");
                    presettledOutput.mediumOutput();}
                case "l" -> {
                    System.out.println("Your low priority task(s):");
                    presettledOutput.lowOutput();}
                default ->
                    System.out.println("Poka no info");}
            System.out.println("Press 0 for exit, any another digit for continue.");
            exxit = exit.nextInt();
        } while(exxit!=0);
    }
}
