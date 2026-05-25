package top_interview_150;

import java.util.Stack;

/**
 * https://leetcode.com/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class EvaluateReversePoliceNotation_150 {

    public static int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<String> stack = new Stack<>();
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperand(token) || stack.isEmpty() || isOperand(stack.peek())) {
                stack.push(token);
            } else {
                while (stack.size() >= 2 && !isOperand(stack.peek())) {
                    int rightOperator = Integer.parseInt(stack.pop());
                    char operand = stack.pop().charAt(0);
                    int leftOperator = Integer.parseInt(token);
                    ans = solveEq(operand, leftOperator, rightOperator);
                    token = String.valueOf(ans);
                }
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private static boolean isOperand(String token) {
        if (token.length() != 1) return false;
        char ch = token.charAt(0);
        return switch (ch) {
            case '+', '-', '/', '*':
                yield true;
            default:
                yield false;
        };
    }

    private static int solveEq(char operand, int left, int right) {
        return switch (operand) {
            case '+':
                yield left + right;
            case '-':
                yield left - right;
            case '*':
                yield left * right;
            default:
                yield left / right;
        };
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        System.out.println(EvaluateReversePoliceNotation_150.evalRPN(tokens));
//        String[] tokens = new String[]{"4","13","5","/","+"};
//        System.out.println(EvaluateReversePoliceNotation_150.evalRPN(tokens));
//        String[] tokens = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        System.out.println(EvaluateReversePoliceNotation_150.evalRPN(tokens));
    }

}
