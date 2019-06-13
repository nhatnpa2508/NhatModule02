import java.util.Random;

public class ProgramCountTime {
    public static void main(String[] args) {
        int size = 100000;
        System.out.println("Đo thời gian thực thi của thuật toán sắp xếp chọn 100.000 số từ biến cho trước");
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        Watch watch = new Watch();
        watch.getStartTime();
        int temp;
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        watch.getEndTime();
        long timeWatch = watch.getElapsedTime();
        System.out.println("Thời gian thực thi là: " + timeWatch);
    }
}
