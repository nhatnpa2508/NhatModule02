public class MovablePoint extends Point{
    float xSpeed = 0.0f;
    float ySpeed = 0.0f;
    public MovablePoint(){}
    public MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(float xSpeed, float ySpeed, float x, float y){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
        this.x = x;
        this.y = y;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }
    public void setXYSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    float[] XYSpeed = {this.xSpeed,this.ySpeed};
    public float[] getXYSpeed(){
        return XYSpeed;
    }

    @Override
    public String toString() {
        return "Position: (x: " + this.x + ", y: " + this.y
                + "), speed = (xSpeed: " + this.xSpeed + ", y: " + this.ySpeed + ")";
    }
    public String move(){
        this.x += this.xSpeed;
        this.y += this.ySpeed;
        return "Position after move: (x: " + this.x + ",y: "+this.y+")";
    }
}
