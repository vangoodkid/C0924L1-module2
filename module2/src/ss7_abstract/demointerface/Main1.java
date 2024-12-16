package ss7_abstract.demointerface;

import ss7_abstract.Circle;
import ss7_abstract.Rectangle;
import ss7_abstract.Shape;
import ss7_abstract.Square;

public class Main1 {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.0);
        shapes[1] = new Square(4.0);
        shapes[2] = new Rectangle(5.0, 6.0);

        double percent = 50.0;

        for (Shape shape : shapes) {
            System.out.println("Trước khi thay đổi kích thước:");
            System.out.println(shape);

            if (shape instanceof IResizeable) {
                System.out.println("Thay đổi kích thước thêm " + percent + "%...");
                ((IResizeable) shape).resize(percent);
            }

            System.out.println("Sau khi thay đổi kích thước:");
            System.out.println(shape);

            if (shape instanceof Circle) {
                System.out.println("Diện tích mới: " + ((Circle) shape).getArea());
            } else if (shape instanceof Rectangle) {
                System.out.println("Diện tích mới: " + ((Rectangle) shape).getArea());
            } else if (shape instanceof Square) {
                System.out.println("Diện tích mới: " + ((Square) shape).getArea());
            }
        }
    }
}
