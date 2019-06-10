public class Cylinder extends Circle{
    double height;
    public Cylinder(){
        this.height = 1;
    }
    public Cylinder(double height){
        this.height = height;
    }
    public Cylinder(double height, String color, double radius){
        super(color, radius);
        this.height = height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void setColor(String color) {
        super.setColor(color);
    }

    @Override
    public String getColor() {
        return super.getColor();
    }

    @Override
    public double getArea() {
        return super.getArea()*2 + getPerimeter()*this.height;
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter();
    }

    @Override
    public double getRadius() {
        return super.getRadius();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
    }
    public double getVolume(){
        return getArea()*this.height;
    }

    @Override
    public String toString() {
        return "A " + getColor() + " Cylinder with radius "
                + getRadius()
                +"\nArea: " + getArea() + "\nVolume: " + this.getVolume();
    }
}
