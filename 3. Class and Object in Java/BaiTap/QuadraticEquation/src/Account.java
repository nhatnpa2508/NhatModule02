import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        System.out.println("Quadratic Equation");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a: ");
        double a = scanner.nextDouble();
        System.out.println("Enter b: ");
        double b = scanner.nextDouble();
        System.out.println("Enter c: ");
        double c = scanner.nextDouble();
        if ( a == 0 &&  c == 0 && b == 0)
            System.out.println("Phương trình vô số nghiệm");
        else {
            Quadratic quadratic = new Quadratic(a,b,c);
            System.out.println("Delta = " + quadratic.getDiscriminant());
            System.out.println("Nghiệm phương trình: " + quadratic.getRoot());
        }
    }
}
