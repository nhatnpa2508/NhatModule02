import java.util.Scanner;

public class SumNumberInTheDiagonalTwo_dimensionalArray {
    public static void main(String[] args) {
        System.out.println("Two-dimensional array - sum the numbers in the diagonal of the square matrix");
        Scanner scanner = new Scanner(System.in);
        int size;
        do {
            System.out.println("Enter size of matrix: ");
            size = scanner.nextInt();
        } while (size <= 0);
        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("Element matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        System.out.println("The matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum += matrix[i][i];
        }
        System.out.println("Sum the numbers in the diagonal of the square matrix: " + sum);
    }
}
