import java.util.Scanner;

class CheckTriAngle extends Exception{
    CheckTriAngle(String str) {
        super(str);
    }
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter angle1: ");
            int angle1 = input.nextInt();
            System.out.println("Enter angle2: ");
            int angle2 = input.nextInt();
            System.out.println("Enter angle3: ");
            int angle3 = input.nextInt();

            if (angle1 < 0 || angle2 < 0 || angle3 < 0 || angle1 + angle2 < angle3 ||
                    angle1 + angle3 < angle2 || angle2 + angle3 < angle1) {
                CheckTriAngle err = new CheckTriAngle("Invalid angle");
                throw err;
            } else {
                System.out.println("Ok");
            }
        } catch (CheckTriAngle e) {
            e.printStackTrace();
        }
    }
}
