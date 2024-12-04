package ss2_vong_lap_java.bai_tap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input= new Scanner(System.in);
        int choice,height,width;
        do{
            System.out.println("chon chuc nang: ");
            System.out.println("0.ket thuc ct");
            System.out.println("1.hinh chu nhat: ");
            System.out.println("2.hinh tam giac vuong bottom left: ");
            System.out.println("3.hinh tam giac vuong top left: ");
            System.out.println("4.tam giac can: ");
            choice = input.nextInt();
            switch (choice){
                case 1 :
                    System.out.println("nhap chieu cao: ");
                    height = input.nextInt();
                    System.out.println("nhap chieu rong: ");
                    width = input.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    break;
                case 2 :
                    System.out.println("nhap chieu cao: ");
                     height = input.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("nhap chieu cao: ");
                    height = input.nextInt();
                    for (int i = height; i > 0; i--) {
                        for (int j = 0; j <= i - 1; j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
                case 4:
                    height = 7;
                    for (int i = 1; i <= height; i++) {
                        for (int j = height; j > i; j--) {
                            System.out.print("   ");
                        }
                        for (int j = 1; j <= (2 * i - 1); j++) {
                            System.out.print(" * ");
                        }
                        System.out.println();
                    }
            }
        }while (choice != 0);

        }
    }

