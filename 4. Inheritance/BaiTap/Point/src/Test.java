public class Test {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);
        point2D = new Point2D(2, 1);
        System.out.println(point2D);
        point2D.setXY(1, 1);
        point2D.setXY(2, 2);
        point2D.setXY(3, 3);
        System.out.println(point2D.arrayXY());

        System.out.println();

        Point3D point3D = new Point3D();
        System.out.println(point3D);
        point3D = new Point3D(1);
        System.out.println(point3D);
        point3D = new Point3D(1, 2, 3);
        System.out.println(point3D);
        point3D.setXYZ(1, 1, 1);
        point3D.setXYZ(2, 2, 2);
        point3D.setXYZ(3, 3, 3);
        System.out.println( point3D.arrayXYZ());

    }
}
