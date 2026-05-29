package top_interview_150;

import java.util.Stack;

/**
 * https://leetcode.com/problems/valid-parentheses/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidParenthesis_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            switch(ch) {
                case '(', '[', '{': {
                    stack.push(ch);
                    break;
                }
                case ')', ']', '}': {
                    char requiredCh = switch (ch) {
                        case ')': yield '(';
                        case ']': yield '[';
                        case '}': yield '{';
                        default:
                            throw new IllegalStateException("Unexpected value: " + ch);
                    };
                    if(!stack.isEmpty() && stack.peek() == requiredCh) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

}
