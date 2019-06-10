import java.util.Scanner;

public class checkPrimeNum {
    public static void main(String[] args) {
        System.out.println("Check Prime Number!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number:");
        int number = scanner.nextInt();

        if (number < 2) {
            System.out.println(number + " is not Prime");
        } else {
            int i = 2;
            boolean check = true;
            while (i <= Math.sqrt(number)) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                i++;
            }
            if (check)
                System.out.println(number + " is Prime");
            else
                System.out.println(number + " is not Prime");
        }
    }
}
