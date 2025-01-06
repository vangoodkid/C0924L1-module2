package s11_dsa;

public class DecimalToBinary {
        public static String convertToBinary(int decimal) {
            String binary = "";
            while (decimal > 0) {
                binary = (decimal % 2) + binary;
                decimal /= 2;
            }
            return binary;
        }

        public static void main(String[] args) {
            int decimal = 30;
            String binary = convertToBinary(decimal);
            System.out.println(decimal + " in binary is: " + binary);
        }
    }

