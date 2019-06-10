import java.util.Scanner;

public class DeleteElementFromArray2 {
    public static void main(String[] args) {
        System.out.println("Delete element from array (2).");
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 5, 9, 10};
        int number, count = 0;
        int[] index_del = new int[array.length];
        System.out.println("Array :");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.println();
        System.out.print("Enter number you want to delete: ");
        number = scanner.nextInt();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                count++;
                index_del[count] = i;
            }
        }
        while (count > 0){
            for (int i = index_del[count]; i < array.length -1;i++){
                array[i] = array[i + 1];
            }
            count--;
            array[array.length-1] = 0;
        }
        System.out.println("Array after delete element: " + number);
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}