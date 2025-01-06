package s11_dsa;

import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int[] arr = {1,3,5,7,9};

        for(int num : arr){
            stack.push(num);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        for(int num : arr){
            System.out.print(num+" ");
        }

    }
}
