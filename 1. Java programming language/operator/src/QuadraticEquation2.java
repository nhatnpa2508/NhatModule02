import java.util.Scanner;

public class QuadraticEquation2 {
    public static void main(String[] args) {
        System.out.println("Given a equation as 'a * x*x + b*x + c = 0', please enter constants:");
        Scanner scanner = new Scanner(System.in);

        System.out.println("a: ");
        double a = scanner.nextDouble();
        System.out.println("b: ");
        double b = scanner.nextDouble();
        System.out.println("c: ");
        double c = scanner.nextDouble();
        double x1,x2;
        if (a ==0){
            if (b ==0 && c ==0)
                System.out.println("The solution is all x");
            if (b == 0 && c !=0)
                System.out.println("No solution!");
        }else {
            double delta = b*b -4*a*c;
            if (delta > 0){
                x1 = (-b+Math.sqrt(delta))/(2*a);
                x2 = (-b-Math.sqrt(delta))/(2*a);
                System.out.println("There are 2 solution is: \nx1 = "+x1+"\nx2 = "+ x2);
            }else if (delta == 0){
                x1 = -b/(2*a);
                System.out.println("The solution is: \nx1 = x2 = "+ x1);
            } else {
                System.out.println("No solution!");
            }
        }
    }
}
