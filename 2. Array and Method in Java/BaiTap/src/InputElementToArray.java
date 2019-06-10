import java.util.Scanner;

public class InputElementToArray {
    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        array[5] = 6;
        array[6] = 7;
        array[7] = 8;
        System.out.print("Property list: ");
        for (int value : array) {
            System.out.print(value + "\t");
        }
        System.out.print("\n");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter index you want to insert:");
        int index = scanner.nextInt();
        if (index < 1 && index > array.length-1){
            System.out.println("Wrong index!");
        } else {
            System.out.println("Valid index.");
            System.out.println("Enter number you want to insert:");
            int number = scanner.nextInt();
            for (int i = array.length -1; i > index;i--){
                array[i] = array[i-1];
            }
            array[index] = number;
            for (int value : array) {
                System.out.print(value + "\t");
            }
        }
    }
}
