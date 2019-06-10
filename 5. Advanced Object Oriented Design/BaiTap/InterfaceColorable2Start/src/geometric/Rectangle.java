package geometric;

import geometric.Shape;

public class Rectangle extends Shape {
    double width,height;
    public Rectangle(){
        this.width = 1;
        this.height = 1;
    }
    public Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }
    public Rectangle(double width, double height, String color, boolean filled){
        super(color, filled);
        this.height = height;
        this.width = width;
    }

    @Override
    public String toString() {
        return "A Rectangle with width="
                + getWidth()
                + " and height="
                + getHeight()
                + ", which is a subclass of "
                + super.toString();
    }

    @Override
    public boolean isFilled() {
        return super.isFilled();
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public void setFilled(boolean filled) {
        super.setFilled(filled);
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
