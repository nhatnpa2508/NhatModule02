import java.util.Scanner;

public class UCLonnhat {
    public static void main(String[] args) {
        System.out.println("Find greatest common divisor of two number");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter first nummber:");
        int firstNum = scanner.nextInt();
        System.out.println("Enter second nummber:");
        int secondNum = scanner.nextInt();

        if (firstNum == 0 || secondNum == 0)
            System.out.println("No greatest common factor");
        else {
            firstNum = Math.abs(firstNum);
            secondNum = Math.abs(secondNum);
            while (firstNum != secondNum) {
                if (firstNum > secondNum)
                    firstNum = firstNum - secondNum;
                else
                    secondNum = secondNum - firstNum;
            }
            System.out.println("Greatest common factor: " + firstNum);
        }
    }
}
