package ss3_arrayy.bai_tap;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr1 = {10, 4, 6, 7, 8, 3, 12};
        int x = input.nextInt();

        System.out.println("mảng lúc ban đầu: ");
        xuat_mang1(arr1);

        int index_del = checkX(arr1, x);
        if (index_del >= 0) {
            xoa_x(arr1, index_del);
            System.out.println("mảng sau khi xóa: ");
            xuat_mang2(arr1);
        } else {
            System.out.println("x k tồn tại trong mảng.");
        }

    }

    private static void xuat_mang1(int[] arr1) {
        for (int n : arr1) {
            System.out.print(n + " ");
        }
        System.out.println();
    }

    private static void xuat_mang2(int[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
    }

    public static void xoa_x(int[] arr1, int saveX) {
        for (int i = saveX; i < arr1.length - 1; i++) {
            arr1[i] = arr1[i + 1];
        }
    }

    public static int checkX(int[] arr1, int x) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] == x) {
                return i;
            }
        }
        return -1;
    }


}
