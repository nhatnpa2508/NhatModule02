import java.util.Scanner;

public class PrintFromMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("4. Exit");
        System.out.println("Enter your choice: ");
        while (true) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    StringBuilder str1 = new StringBuilder();
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 6; j++) {
                            str1.append("* ");
                        }
                        str1.append("\n");
                    }
                    System.out.println(str1);
                    break;
                case 2:
                    StringBuilder str2 = new StringBuilder();
                    for (int i = 0; i < 6; i++) {
                        for (int j = 0; j < i; j++) {
                            str2.append("* ");
                        }
                        str2.append("\n");
                    }
                    str2.append("\n");
                    for (int i = 5; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            str2.append("* ");
                        }
                        str2.append("\n");
                    }
                    str2.append("\n");
                    for (int i = 1; i <= 5; i++) {
                        for (int h = 5; h > i; h--) {
                            str2.append("  ");
                        }
                        for (int j = 0; j < i; j++) {
                            str2.append("* ");
                        }
                        str2.append("\n");
                    }
                    str2.append("\n");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j < i; j++) {
                            str2.append("  ");
                        }
                        for (int h = 5; h >= i; h--) {
                            str2.append("* ");
                        }
                        str2.append("\n");
                    }
                    System.out.println(str2);
                    break;
                case 3:
                    StringBuilder str3 = new StringBuilder();
                    for (int i = 1; i <= 5; i++) {
                        for (int h = 5; h > i; h--) {
                            str3.append(" ");
                        }
                        for (int j = 1; j <= i; j++) {
                            str3.append(" *");
                        }
                        str3.append("\n");
                    }
                    str3.append("\n");
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            str3.append(" ");
                        }
                        for (int h = 5; h >= i; h--) {
                            str3.append("* ");
                        }
                        str3.append("\n");
                    }
                    System.out.println(str3);
                    break;
                case 4:
                    System.out.println("Exit");
                    System.exit(0);
                default:
                    System.out.println("No choice!");
            }
        }
    }
}
