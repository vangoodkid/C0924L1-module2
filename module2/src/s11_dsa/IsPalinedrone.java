package s11_dsa;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsPalinedrone {
    public String isPalindrome(String input) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();


        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                char normal = Character.toLowerCase(c);
                stack.push(normal);
                queue.offer(normal);
            }
        }

        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.poll()) {
                return "Chuỗi không phải Palindrome";
            }
        }

        return "Chuỗi là Palindrome";
    }

    public static void main(String[] args) {
        IsPalinedrone checker = new IsPalinedrone();
        String testString = "A man a plan a canal Panama";
        System.out.println(checker.isPalindrome(testString));
    }
}
