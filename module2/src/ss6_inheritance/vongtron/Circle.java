package ss6_inheritance.vongtron;

public class Circle {
        public double radius;
        public String color;

    public Circle() {
        this.radius = 5.0;
        this.color = "black";
    }

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color +", area="+ getArea() +'\'' +
                '}';
    }
}
