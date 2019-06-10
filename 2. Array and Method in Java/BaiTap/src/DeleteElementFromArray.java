import java.util.Scanner;

public class DeleteElementFromArray {
    public static void main(String[] args) {
        System.out.println("Delete element from array.");
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int index_del;
        System.out.println("Array :");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
        System.out.print("Enter index you want to delete:");
        index_del = scanner.nextInt();
        while (index_del < 0 && index_del > array.length) {
            System.out.println("Index wrong");
            index_del = scanner.nextInt();
        }
        for (int i = index_del; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = 0;
        System.out.println("Array after delete element at index " + index_del+" :");
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}
