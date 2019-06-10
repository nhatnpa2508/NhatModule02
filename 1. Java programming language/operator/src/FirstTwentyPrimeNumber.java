import java.util.Scanner;

public class FirstTwentyPrimeNumber {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Print first 20 prime number");
            int countNum = 0;
            for (int number = 0; number <= 100; number++) {
                if (number == 2) {
                    countNum++;
                    System.out.println(number + " is Prime + '"+countNum+"'");
                }
                if (number > 2) {
                    int count = 0;
                    for (int i = 2; i <= Math.sqrt(number); i++) {
                        if (number % i == 0){
                            count++;
                            break;
                        }
                    }
                    if (count ==0) {
                        countNum++;
                        System.out.println(number + " is Prime + '"+countNum+"'");
                    }
                }
                if (countNum == 20)
                    break;
            }
        }
    }
