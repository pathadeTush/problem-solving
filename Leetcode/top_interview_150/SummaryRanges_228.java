package top_interview_150;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/summary-ranges/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SummaryRanges_228 {

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        if (n < 1) {
            return Collections.emptyList();
        }

        List<String> ans = new ArrayList<>();
        int start = nums[0];
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num - nums[i - 1] != 1) {
                if(start != nums[i-1]) {
                    ans.add(start + "->" + nums[i - 1]);
                } else {
                    ans.add(String.valueOf(start));
                }
                start = num;
            }
        }

        if(start != nums[n-1]) {
            ans.add(start + "->" + nums[n - 1]);
        } else {
            ans.add(String.valueOf(start));
        }
        return ans;
    }

}
