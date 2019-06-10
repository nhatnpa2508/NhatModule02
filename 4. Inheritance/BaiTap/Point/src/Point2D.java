public class Point2D {
    float x = 0.0f;
    float y = 0.0f;
    public Point2D(){}
    public Point2D(float x, float y){
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
    int i =0;
    float[][] arrayXY = new float[10][2];
    public void setXY(float x, float y){
        this.arrayXY[i][0] = x;
        this.arrayXY[i][1] = y;
        i++;
    }
    public float[][] getXY(){
        return arrayXY;
    }
    public String toString(){
        return "Position: \nx: " + this.x + " \t y: " + this.y
                + "\n";
    }
    public String arrayXY(){
        String str = "Position: \n";
        for (int j = 0; j < i;j++){
            str+= "( "+ arrayXY[j][0] + ", "+arrayXY[j][1]+")\n";
        }
        return str;
    }
}
