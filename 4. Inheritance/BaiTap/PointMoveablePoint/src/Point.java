public class Point {
    float x = 0.0f;
    float y = 0.0f;
    public Point(){}
    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    float[] arrayXY = new float[2];
    public void setXY(float x, float y){
        this.arrayXY[0] = x;
        this.arrayXY[1] = y;
    }
    public float[] getXY(){
        return arrayXY;
    }
    public String toString(){
        return "Position: x: " + this.x + " \t y: " + this.y;
    }
    public String getXYPosition(){
        return "Position: (x: "+ arrayXY[0] + ",y: "+arrayXY[1]+")";
    }
}
