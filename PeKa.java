import java.util.Scanner;

public class PeKa {
    public static void main (String[] args) {

Output presettledOutput = new Output();
String u;

        System.out.println("Please enter priority first letter: ");
        System.out.println("u - Urgent\nh - High\nm - Medium\nl - low");
        System.out.println("or a for all.\nAny another button for statistic.");
        Scanner priorScan = new Scanner(System.in);
        u = priorScan.nextLine();

        switch (u) {

            case "a" :
                presettledOutput.fullOutput();
                break;
            case "u" :
                System.out.println("Your task(s) with urgent priority:");
                presettledOutput.urgentOutput();
                break;
            case "h" :
                System.out.println("Your high priority task(s):");
                presettledOutput.highOutput();
                break;
            case "m" :
                System.out.println("Your medium priority task(s):");
                presettledOutput.mediumOutput();
                break;
            case "l" :
                System.out.println("Your low priority task(s):");
                presettledOutput.lowOutput();
                break;
            default:
                System.out.println("Poka no info");
        }
    }
}
