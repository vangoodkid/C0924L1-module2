package ss7_abstract;

public class Shape {
    public String color = "blue";
    public boolean fill = true;

    public Shape() {
    }

    public Shape(String color, boolean fill) {
        this.color = color;
        this.fill = fill;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    @Override
    public String toString() {
        return " color = " + getColor() + '\'' +
                (isFill() ? ", fill " : "not fill");
    }
}
