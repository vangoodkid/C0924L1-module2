package ss3_arrayy.bai_tap;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("nhập kích thước mảng: ");
        int size = input.nextInt();
        int[] matrix = new int[size];
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("nhap phan tu thu "+(i+1)+": ");
            matrix[i] = input.nextInt();
        }
        int minValue = matrix[0];
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i] < minValue){
                minValue = matrix[i];
            }
        }
        System.out.println("giá trị nhỏ nhất trong mảng là: "+ minValue);
    }
}
