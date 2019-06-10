package geometric;

public class TestColorable {
    public static void main(String[] args) {
        Object[] geometric = new Object[3];
        geometric[0] = new Circle(5);
        geometric[1] = new Rectangle(5,10);
        geometric[2] = new Square(5);
        for (int i = 0; i< geometric.length;i++){
            System.out.println(geometric[i]);
            System.out.println();
        }
    }
}
