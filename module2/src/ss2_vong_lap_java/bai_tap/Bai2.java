package ss2_vong_lap_java.bai_tap;

public class Bai2 {
    public static boolean checkIsprime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int n = 2;
        int count = 0;
        while (count < 20) {
            if (checkIsprime(n)) {
                System.out.print(n + " ");
                count++;
            }
            n++;
        }
    }
}
