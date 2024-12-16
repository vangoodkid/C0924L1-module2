package ss7_abstract;

public class Circle extends Shape{
    public double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, boolean fill, double radius) {
        super(color, fill);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea(){
        return radius * radius * Math.PI;
    }
    public double getPerimeter(){
        return Math.PI * 2 * radius;
    }

    @Override
    public String toString() {
        return "radius=" + getRadius() +
               super.toString();
    }
    public void resize(double percent) {
        this.radius *= Math.sqrt(1 + percent / 100);
    }
}
