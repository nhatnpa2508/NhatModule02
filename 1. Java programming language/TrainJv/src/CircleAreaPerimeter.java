import java.util.Scanner;

public class CircleAreaPerimeter {
    public static void main(String[] args) {
        System.out.println("Program calculate Area and Perimeter Circle.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius(cm): ");
        double radius = scanner.nextDouble();

        double area = Math.PI * radius * radius;
        double perimeter = 2* Math.PI *radius;
        System.out.println("Area circle = " + area +"cm2\nPerimeter circle = " + perimeter + "cm");

    }
}
