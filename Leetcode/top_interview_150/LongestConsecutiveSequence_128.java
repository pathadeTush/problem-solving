package top_interview_150;

import java.util.TreeSet;

/**
 * https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestConsecutiveSequence_128 {

    public static int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int ans = 0;
        int count = 1;
        boolean firstSkipped = false;
        int prev = 0;
        for(int num: set) {
            if(!firstSkipped) {
                prev = num;
                firstSkipped = true;
                ans = 1;
                continue;
            }
            if(num-prev == 1) {
                count++;
                prev = num;
            } else {
                count = 1;
                prev = num;
            }
            ans = Math.max(ans, count);
        }

        return ans;
    }

}
