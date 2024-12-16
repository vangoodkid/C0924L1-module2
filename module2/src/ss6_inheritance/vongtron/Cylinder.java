package ss6_inheritance.vongtron;

public class Cylinder extends Circle {

    public double height;

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Cylinder [radius = " + getRadius() + ", color = " + getColor() + ", height = " + getHeight() + ", volume = " + getVolume() + "]";
    }
}


