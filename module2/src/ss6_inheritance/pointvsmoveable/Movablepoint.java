package ss6_inheritance.pointvsmoveable;

public class Movablepoint extends Point {
    public float xSpeed = 0.0f;
    public float ySpeed = 0.0f;

    public Movablepoint() {
    }

    public Movablepoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public Movablepoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[]{xSpeed, ySpeed};
    }

    public Movablepoint move() {
        setXY(getX() + xSpeed, getY() + ySpeed);
        return this;
    }

    @Override
    public String toString() {
        return super.toString()  +
                " xSpeed= " + xSpeed +
                ", ySpeed = " + ySpeed ;
    }

}
