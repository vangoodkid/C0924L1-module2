package ss3_arrayy.bai_tap;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        double[][] maxtrix = {
                {3.5,4.1,5.5},
                {9.5,1,2,7.5},
                {8.1,2.4,9.8}
        };
        double maxValue = maxtrix[0][0];
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < maxtrix.length; i++) {
            for (int j = 0; j < maxtrix[i].length; j++) {
                if (maxtrix[i][j] > maxValue){
                    maxValue = maxtrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }
        System.out.println("giá trị lớn nhất trong ma trận là: "+ maxtrix);
        System.out.println("tọa độ lớn nhất trong ma trận: "+ maxRow+" và "+maxCol);
    }
}
