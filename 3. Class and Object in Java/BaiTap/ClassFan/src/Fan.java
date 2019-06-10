public class Fan {
    final String SLOW = "SLOW";
    final String MEDIUM = "MEDIUM";
    final String FAST = "FAST";
    int speed = 1;
    boolean onOff = false;
    double radius = 5;
    String color = "Blue";
    String name;

    public Fan() {
    }

    ;

    public Fan(double radius, String color, String name, int speed, boolean onOff) {
        this.radius = radius;
        this.color = color;
        this.name = name;
        this.onOff = onOff;
        if (speed > 3)
            this.speed = 3;
        else if (speed > 0)
            this.speed = speed;
        else
            this.speed = 0;
    }

    public String checkOnOff() {
        if (this.onOff)
            return "\nFan is On";
        else return "\nFan is Off";
    }

    public int checkSpeed() {
        if (this.onOff)
            return this.speed;
        else return 0;
    }

    public String information() {
        if (this.onOff)
            return this.name + " Fan: \nSpeed: " + this.speed + "\nColor: " + this.color + "\nRadius: " + this.radius + this.checkOnOff() + "\n";
        else
            return this.name + " Fan: \nColor: " + this.color + "\nRadius: " + this.radius + this.checkOnOff() + "\n";
    }
}
