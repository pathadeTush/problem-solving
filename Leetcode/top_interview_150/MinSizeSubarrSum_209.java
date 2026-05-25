package top_interview_150;

/**
 * https://leetcode.com/problems/minimum-size-subarray-sum/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinSizeSubarrSum_209 {

//    public static int minSubArrayLen(int target, int[] nums) {
//        int n = nums.length;
//        int ans = n + 1;
//        for (int i = 0; i < n; i++) {
//            int subArrSum = 0;
//            for (int j = i; j < n; j++) {
//                subArrSum += nums[j];
//                if (subArrSum >= target) {
//                    ans = Math.min(ans, j + 1 - i);
//                    break;
//                }
//            }
//        }
//
//        return ans == n + 1 ? 0 : ans;
//    }

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int startIdx = 0;
        int sum = 0;
        int ans = n + 1;
        int i = 0;
        while (i < n) {
            sum += nums[i];
            if(sum >= target) {
                while (sum >= target) {
                    ans = Math.min(ans, i-startIdx+1);
                    sum -= nums[startIdx];
                    startIdx++;
                }
            }
            i++;
        }

        return ans == n + 1 ? 0 : ans;
    }

}
