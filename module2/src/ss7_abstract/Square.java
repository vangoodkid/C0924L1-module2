package ss7_abstract;

import ss7_abstract.demointerface.IColorable;
import ss7_abstract.demointerface.IResizeable;

public class Square extends Shape implements IResizeable, IColorable {
    public double side = 1.0;

    public Square() {
    }

    public Square(double side) {
        this.side = side;
    }

    public Square(String color, boolean fill, double side) {
        super(color, fill);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return side * side;
    }

    public void resize(double percent) {
        this.side *= (1 + percent / 100);
    }

    @Override
    public void howtoColor() {
        System.out.println("color is filled");
    }

    @Override
    public String toString() {
        return " side= " + getSide() +
                super.toString();
    }
}
