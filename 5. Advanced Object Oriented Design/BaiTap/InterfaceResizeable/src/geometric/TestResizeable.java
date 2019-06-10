package geometric;

import java.util.Random;

public class TestResizeable {
    public static void main(String[] args) {
        Circle circle = new Circle(10);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println(rectangle);

        Square square = new Square(10);
        System.out.println(square);
        System.out.println();

        Random rd = new Random();
        int[] array = new int[5];

        for (int i = 0; i<array.length;i++){
            array[i] = rd.nextInt(100)-1;

            circle.resize(array[i]);
            rectangle.resize(array[i]);
            square.resize(array[i]);

            System.out.println(circle);
            System.out.println(rectangle);
            System.out.println(square);
            System.out.println();

        }
    }
}
