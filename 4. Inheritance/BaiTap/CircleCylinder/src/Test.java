public class Test {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle("red", 5);
        System.out.println(circle);
        System.out.println();
        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);
        cylinder = new Cylinder(5);
        System.out.println(cylinder);
        cylinder = new Cylinder(5,"red",5);
        System.out.println(cylinder);
    }
}
