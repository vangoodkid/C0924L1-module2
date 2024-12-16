package ss7_abstract;

import ss7_abstract.demointerface.IResizeable;

public class Rectangle extends Shape implements IResizeable {
    public double width = 2.0;
    public double length = 2.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean fill, double width, double length) {
        super(color, fill);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
    public double getArea() {
        return this.width * this.length;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.length);
    }

    @Override
    public String toString() {
        return " width= "
                + getWidth()
                + "  length="
                + getLength()
                + " subclass "
                + super.toString();
    }
    public void resize(double percent) {
        this.width *= (1 +  percent / 100);
        this.length *= (1 +  percent / 100);
    }
}
