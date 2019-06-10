public class Quadratic {
    double a, b, c,delta;
    boolean check;

    public Quadratic(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public double getDiscriminant(){
        this.delta = Math.pow(b,2)-4*a*c;
        return this.delta;
    }
    public double getRoot1(){
        return (-b+Math.sqrt(this.delta))/(2*a);
    }
    public double getRoot2(){
        return (-b-Math.sqrt(this.delta))/(2*a);
    }
    public String getRoot(){
        if (this.delta > 0){
            return "\nPhương trình có 2 nghiệm là: \nx1 = " + getRoot1()+"\nx2 = " + getRoot2();
        } else if (this.delta == 0)
            return "\nPhương trình có 1 nghiệm kép là: \nx1 = " + getRoot1();
        else return "\nPhương trình vô nghiệm";
    }
}
