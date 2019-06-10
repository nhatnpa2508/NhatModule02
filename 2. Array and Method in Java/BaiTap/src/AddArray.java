public class AddArray {
    public static void main(String[] args) {
        System.out.println("Add 2 array");
        int[] array1 = {1,3,5,7,9};
        int[] array2 = {0,2,4,6,8};
        int size = array1.length + array2.length;
        int[] array = new int[size];
        System.out.println("Array 1:");
        for (int item : array1) {
            System.out.print(item + "\t");
        }
        System.out.println();
        System.out.println("Array 2:");
        for (int item : array2) {
            System.out.print(item + "\t");
        }
        System.arraycopy(array1, 0, array, 0, array1.length);
        System.arraycopy(array2, 0, array, array1.length, size - array1.length);
        System.out.println();
        System.out.println("Array = Array 1 + Array 2:");
        for (int value : array) {
            System.out.print(value + "\t");
        }
    }
}
