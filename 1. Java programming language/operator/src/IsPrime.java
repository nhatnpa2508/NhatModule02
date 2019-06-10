import java.util.Scanner;

public class IsPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print Prime Number < 100");
        int number;
        for (number = 0; number <= 100; number++) {
            if (number == 2)
                System.out.println(number + " is Prime");
            if (number > 2) {
                int count = 0;
                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0){
                        count++;
                        break;
                    }
                }
                if (count ==0)
                    System.out.println(number + " is Prime");
            }
        }
    }
}
