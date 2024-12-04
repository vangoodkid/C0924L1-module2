package ss2_vong_lap_java.bai_tap;

public class DemoLaibt {
    public static boolean checkPrime(int n) {
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
    private static boolean checkIsPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int count = 0;
        for (int n = 2; n < 100; n++) {
            if (checkIsPrime(n)) {
                System.out.print(n + " ");
            }
        }
    }
}