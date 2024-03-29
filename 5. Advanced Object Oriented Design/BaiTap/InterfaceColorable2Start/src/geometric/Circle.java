package geometric;

import geometric.Shape;

public class Circle extends Shape {
    public double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public void setColor(String color) {
        super.setColor(color);
    }

    public void setFilled(boolean filled) {
        super.setFilled(filled);
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public boolean isFilled() {
        return super.isFilled();
    }

    public String getColor() {
        return super.getColor();
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "A Circle with radius="
                + getRadius()
                + ", which is a subclass of "
                + super.toString();
    }
}
