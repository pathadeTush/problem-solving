package top_interview_150;

import java.util.Stack;

/**
 * https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWordsInString_151 {

    public static String reverseWords(String s) {
        StringBuffer sb = new StringBuffer();
        Stack<String> st = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch == ' ') {
                if(!sb.isEmpty()) {
                    st.push(sb.toString());
                    sb = new StringBuffer();
                }
            } else {
                sb.append(ch);
            }
        }
        if(!sb.isEmpty()) {
            st.push(sb.toString());
        }

        sb = new StringBuffer();
        while (!st.isEmpty()) {
            sb.append(st.pop());
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(ReverseWordsInString_151.reverseWords(s));
    }

}
