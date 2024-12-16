package ss6_inheritance.pointvsmoveable;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(2.0f,3.0f);
        System.out.println(point);
        point.setXY(4.0f,5.0f);
        System.out.println(point);

        Movablepoint moveablepoint = new Movablepoint(6.0f,7.0f,8.0f,9.0f);
        System.out.println(moveablepoint);

        moveablepoint.move();
        System.out.println("move: "+moveablepoint);

        moveablepoint.setSpeed(7.0f,7.0f);
        moveablepoint.move();
        System.out.println("new speed: "+moveablepoint);
    }

}
