public class TriangleExtends extends Shape {
    double side1 = 1;
    double side2 = 1;
    double side3 = 1;
    boolean check = false;

    public TriangleExtends() {
    }

    public TriangleExtends(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public TriangleExtends(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public boolean isFilled() {
        return super.isFilled();
    }

    double[] triangle = new double[3];

    public boolean isCheck() {
        triangle[0] = this.side1;
        triangle[1] = this.side2;
        triangle[2] = this.side3;
        double perimeter = getPerimeter();
        for (int i = 0; i < 3; i++) {
            if (triangle[i] < (perimeter - triangle[i])) {
                this.check = true;
            } else {
                this.check = false;
                break;
            }
        }
        return this.check;
    }

    public String check() {
        if (!isCheck())
            return "Side 1, side 2, side 3 IS NOT the side of the triangle";
        else return "Side 1, side 2, side 3 is the side of the triangle";
    }

    public double getArea() {
        double p = getPerimeter() / 2;
        double area = Math.sqrt(p * (p - this.side1) * (p - this.side2) * (p - this.side3));
        return area;
    }

    public double getPerimeter() {
        double perimeter = this.side1 + this.side2 + this.side3;
        return perimeter;
    }

    public String toString() {
        if (isCheck()) {
            return "A Shape with color of " + getColor()+ "\nSide1: " + this.side1 + ", side2: " + this.side2 + ", side3: " + this.side3
                    + "\nArea: " + getArea()
                    + "\nPerimeter: " + getPerimeter()
                    + " and " + (isFilled() ? "filled" : "not filled");
        } else
            return "Side1: " + this.side1 + ", side2: " + this.side2 + ", side3: " + this.side3 + " IS NOT the side of the triangle";
    }
}
