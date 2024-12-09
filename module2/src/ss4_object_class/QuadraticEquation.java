package ss4_object_class;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }


    public double getB() {
        return b;
    }


    public double getC() {
        return c;
    }


    public double getDiscriminant() {
        return (b * b) - (4 * a * c);
    }

    public double getRoot1() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b + Math.sqrt(delta)) / (2 * a);
        } else {
            return 0;
        }
    }

    public double getRoot2() {
        double delta = getDiscriminant();
        if (delta >= 0) {
            return (-b - Math.sqrt(delta)) / (2 * a);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nhập giá trị cho a: ");
        double a = input.nextDouble();
        System.out.print("Nhập giá trị cho b: ");
        double b = input.nextDouble();
        System.out.print("Nhập giá trị cho c: ");
        double c = input.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double delta = equation.getDiscriminant();
        if (delta > 0) {
            System.out.printf("Phương trình có 2 nghiệm phân biệt: %.2f và %.2f%n", equation.getRoot1(), equation.getRoot2());
        } else if (delta == 0) {
            System.out.printf("Phương trình có 1 nghiệm kép: %.2f%n", equation.getRoot1());
        } else {
            System.out.println("phuong trinh vo nghiem");
        }
    }
}
