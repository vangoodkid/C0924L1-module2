package ss3_arrayy.bai_tap;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhap kich thuoc cho mang 1: ");
        int n1 = input.nextInt();
        int[] arr1 = new int[n1];

        System.out.println("nhap kich thuoc cho mang 2: ");
        int n2 = input.nextInt();
        int[] arr2 = new int[n2];

        System.out.println("nhập phần tử cho mảng 1:  ");
        for (int i = 0; i < n1; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arr1[i] = input.nextInt();
        }
        System.out.println("nhập phần tử cho mảng 2:  ");
        for (int i = 0; i < n2; i++) {
            System.out.println("nhập phần tử thứ " + (i + 1));
            arr2[i] = input.nextInt();
        }
        int[] arr3 = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            arr3[i] = arr1[i];
        }
        for (int i = 0; i < n2; i++) {
            arr3[n1 + i] = arr2[i];
        }
        for (int n : arr3) {
            System.out.print(n + " ");
        }
    }
}
