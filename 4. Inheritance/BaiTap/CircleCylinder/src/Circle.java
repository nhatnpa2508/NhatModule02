public class Circle {
    String color;
    double radius;
    public Circle(){
        this.color = "Blue";
        this.radius = 1;
    }
    public Circle(String color, double radius){
        this.color = color;
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public double getArea(){
        return (Math.pow(this.radius,2)*Math.PI);
    }
    public double getPerimeter(){
        return (this.radius*2*Math.PI);
    }
    @Override
    public String toString() {
        return "A " + getColor() + " Circle with radius "
                + getRadius()
                +"\nArea: " + getArea()
                +"\nPerimeter: " + getPerimeter();
    }
}
