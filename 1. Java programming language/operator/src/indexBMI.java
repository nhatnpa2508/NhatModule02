import java.util.Scanner;

public class indexBMI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight (in kilogram): ");
        double weight = scanner.nextDouble();
        System.out.println("Enter height (in meter): ");
        double height = scanner.nextFloat();
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 0)
            System.out.printf("%-20.2f%s", bmi,"Wrong input");
        else if (bmi < 18.5)
            System.out.printf("%-20.2f%s", bmi,"Underweight");
        else if (bmi < 25)
            System.out.printf("%-20.2f%s", bmi,"Normal");
        else if (bmi < 30)
            System.out.printf("%-20.2f%s", bmi,"Overweight");
        else
            System.out.printf("%-20.2f%s", bmi,"Obese");
    }
}
