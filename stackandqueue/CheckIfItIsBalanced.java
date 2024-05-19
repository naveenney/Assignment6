package stackandqueue;
import java.util.*;

public class CheckIfItIsBalanced {

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Enter the input:");
        String input = sc.next();
        System.out.println("Is the string balanced? " + isBalanced(input));
    }

 public static boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (!isMatchingPair(last, ch)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
               (open == '[' && close == ']') ||
               (open == '{' && close == '}');
    }
}
