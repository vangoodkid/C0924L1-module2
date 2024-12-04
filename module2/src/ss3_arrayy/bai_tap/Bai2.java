package ss3_arrayy.bai_tap;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1 = {10, 4, 6, 7, 8, 3, 12, 9, 2, 5};

        System.out.println("mảng ban đầu: ");
        xuat_mang(arr1);

        System.out.println("nhập x cần thêm: ");
        int x = input.nextInt();
        System.out.println("nhập vị trí cần chèn: ");
        int index = input.nextInt();

        if (index < 0 || index > arr1.length) {
            System.out.println("k chèn x vào mảng dc.");
        } else {
            arr1 = add_x(arr1, x, index);
            System.out.println("mảng sau khi thêm.");
            xuat_mang(arr1);

        }
    }

    private static int[] add_x(int[] arr1, int x, int index) {
        int[] newArr = new int[arr1.length + 1];

        for (int i = 0; i < index; i++) {
            newArr[i] = arr1[i];
        }

        newArr[index] = x;

        for (int i = index; i < arr1.length ; i++) {
            newArr[i + 1] =  arr1[i];
        }
        return newArr;
    }


    private static void xuat_mang(int[] arr1) {
        for (int n : arr1) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

}
