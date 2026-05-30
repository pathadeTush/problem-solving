package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] ans = new int[]{-1, -1};
        if(n < 2) return ans;

        Map<Integer, Integer> eleIndex = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num1 = nums[i];
            int num2 = target-num1;
            if(eleIndex.containsKey(num2)) {
                return new int[]{i, eleIndex.get(num2)};
            } else {
                eleIndex.put(num1, i);
            }
        }

        return new int[]{-1, -1};
    }

}
