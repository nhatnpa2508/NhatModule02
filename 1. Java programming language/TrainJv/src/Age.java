import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        System.out.println("Calculate Age.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year of birth:");
        int yearOfBirth = scanner.nextInt();
        int age = 2019 - yearOfBirth;
        System.out.println("Age: " +age);
    }
}
