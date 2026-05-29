package top_interview_150;

/**
 * https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLastWord_58 {

    public int lengthOfLastWord(String s) {
        int n = s.length();
        int len = 0;
        int i = n-1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') {
            len++;
            i--;
        }

        return len;
    }

}
