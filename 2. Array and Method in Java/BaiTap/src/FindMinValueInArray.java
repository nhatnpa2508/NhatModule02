import java.util.Scanner;

public class FindMinValueInArray {
    public static void main(String[] args) {
        System.out.println("Find min value of Array.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter SIZE of array");
        int size = scanner.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++){
            System.out.print("Element " + (i+1) + " : ");
            array[i] = scanner.nextInt();
        }
        int index = minValue(array);
        System.out.println("Min value of Array is:" + array[index] +"\nAt position: " +(index+1));
    }
    public static int minValue(int []array){
        int min = array[0];
        int index = 0;
        for (int i = 1; i < array.length; i++){
            if(array[i] < min) {
                min = array[i];
                index = i;
            }
        }
        return index;
    }
}
