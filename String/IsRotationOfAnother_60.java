import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsRotationOfAnother_60 {

    public static boolean areRotations1(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        Queue<Character> q1 = new LinkedList<>();
        for (int i = 0; i < s1.length(); i++) {
            q1.add(s1.charAt(i));
        }

        Queue<Character> q2 = new LinkedList<>();
        for (int i = 0; i < s2.length(); i++) {
            q2.add(s2.charAt(i));
        }

        int k = s2.length();
        while (k > 0) {
            k--;
            char ch = q2.peek();
            q2.remove();
            q2.add(ch);
            if (q2.equals(q1))
                return true;
        }

        return false;
    }

    /**
     * if s2 is rotation of s1, then s2 must be substring of s1+s1
     */
    public static boolean areRotations2(String s1, String s2) {
        String combined = s1 + s1;
        return combined.contains(s2);
    }

    public static boolean checkRotation(String s1, String s2, int idx) {
        int len = s1.length();
        for(int i = 0; i < len; i++) {
            if(s2.charAt(i) != s1.charAt((i+idx)%len)) {
                return false;
            }
        }

        return true;
    }

    public static boolean areRotations(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int len = s1.length();
        List<Integer> occurrenceOfFirstCh = new ArrayList<>();
        char firstCh = s2.charAt(0);

        for(int i = 0; i < len; i++) {
            if(s1.charAt(i) == firstCh) {
                occurrenceOfFirstCh.add(i);
            }
        }

        for(int idx: occurrenceOfFirstCh) {
            if(checkRotation(s1, s2, idx)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        String s1 = "geeksforgeeks";
        String s2 = "forgeeksgeeks";

        System.out.println(areRotations(s1, s2));
    }

}
