import java.util.Scanner;

public class SumTheNumbersInColumn {
    public static void main(String[] args) {
        System.out.println("Sum the numbers in a column");
        Scanner scanner = new Scanner(System.in);
        int row,col;
        do {
            System.out.println("Enter ROW of Array: ");
            row = scanner.nextInt();
        } while (row <= 0);
        do {
            System.out.println("Enter COLUMN of Array: ");
            col = scanner.nextInt();
        } while (col <= 0);
        int[][] array = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("Element Array[" + i + "][" + j + "]: ");
                array[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Array:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        int num;
        do {
            System.out.println("Enter the COLUMN of Array you want to sum: ");
            num = scanner.nextInt();
        } while (num <= 0 && num > col-1);
        int sum =0;
        for (int i = 0; i < array.length;i++){
            sum+= array[i][num];
        }
        System.out.println("Sum the numbers in column '" + num + "' = " + sum);
    }
}
