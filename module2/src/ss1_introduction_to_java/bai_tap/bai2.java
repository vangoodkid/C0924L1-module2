package ss1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nha so tien dollar: ");
        double usd = input.nextDouble();
        double rate = usd*23000;
        System.out.println("gia trin vnd: "+rate);
    }
}
