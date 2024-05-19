package stackandqueue;

import java.util.*;

public class InfixToPostfix {

    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
        System.out.println("Enter the input:");
        String infix=sc.next();
        System.out.println("Postfix: " + infixToPostfix(infix));
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            
            if (Character.isLetterOrDigit(c)) {
                result.append(c).append(' ');
            } 
            
            else if (c == '(') {
                stack.push(c);
            } 
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop()).append(' ');
                }
                stack.pop();
            } 
         
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop()).append(' ');
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop()).append(' ');
        }

        return result.toString().trim();
    }
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

   private static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }
}
