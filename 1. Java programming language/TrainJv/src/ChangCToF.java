import java.util.Scanner;
public class ChangCToF {
    public static void main(String[] args) {
        System.out.println("Program change degree C to degree F");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter degree C: ");
        double degreeC = scanner.nextDouble();
        double degreeF = ((9*degreeC)/5) + 32;
        System.out.println("Result = " + degreeF);
    }
}
