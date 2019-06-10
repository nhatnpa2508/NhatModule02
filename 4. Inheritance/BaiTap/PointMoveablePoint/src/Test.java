public class Test {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        point = new Point(2, 1);
        System.out.println(point);
        point.setXY(3, 3);
        System.out.println(point.getXYPosition());

        System.out.println();
        MovablePoint movablePoint = new MovablePoint();
        System.out.println(movablePoint);
        movablePoint = new MovablePoint( 2, 2);
        System.out.println(movablePoint);
        movablePoint = new MovablePoint( 3, 3,2,2);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move());
    }
}
