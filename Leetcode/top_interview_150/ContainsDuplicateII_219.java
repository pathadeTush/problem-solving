package top_interview_150;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainsDuplicateII_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> numIndexMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            int num = nums[i];
            if(numIndexMap.containsKey(num) && Math.abs(i - numIndexMap.get(num)) <= k) {
                return true;
            } else {
                numIndexMap.put(num, i);
            }
        }

        return false;
    }

}
