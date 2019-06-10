public class Point3D extends Point2D {
    float z = 0.0f;

    public Point3D() {
    }

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public float getX() {
        return super.getX();
    }

    @Override
    public float getY() {
        return super.getY();
    }

    @Override
    public void setX(float x) {
        super.setX(x);
    }

    @Override
    public void setY(float y) {
        super.setY(y);
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    int i = 0;
    float[][] arrayXYZ = new float[10][3];

    public void setXYZ(float x, float y, float z) {
        this.arrayXYZ[i][0] = x;
        this.arrayXYZ[i][1] = y;
        this.arrayXYZ[i][2] = z;
        i++;
    }

    public float[][] getXYZ() {
        return arrayXYZ;
    }

    @Override
    public String toString() {
        return "Position: \nx: " + this.x + " \t y: " + this.y
                + "\tz: " + this.z;
    }

    public String arrayXYZ() {
        String str = "Position: \n";
        for (int j = 0; j < i; j++) {
            str += "( " + this.arrayXYZ[j][0] + ", " + this.arrayXYZ[j][1] + ", " + this.arrayXYZ[j][2] + ")\n";
        }
        return str;
    }
}
