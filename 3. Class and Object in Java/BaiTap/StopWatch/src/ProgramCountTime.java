import java.util.Random;

public class ProgramCountTime {
    public static void main(String[] args) {
        System.out.println("Đo thời gian thực thi của thuật toán sắp xếp chọn 100.000 số từ biến cho trước");
        int[] array = new int[100000];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt();
        }
        Watch watch = new Watch();
        watch.getStartTime();
        int  temp;
        for  ( int  i =  0 ; i <array.length -  1 ; i ++) {
            for  ( int  j =  0 ; j <array.length -  1  - i; j ++) {
                if  (array [j]> array [j +  1 ]) {
                    temp = array [j];
                    array [j] = array [j +  1 ];
                    array [j +  1 ] = temp;
                }
            }
        }
        watch.getEndTime();
        long timeWatch = watch.getElapsedTime();
        System.out.println("Thời gian thực thi là: "+timeWatch);
    }
}
