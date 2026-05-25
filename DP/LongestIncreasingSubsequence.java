import java.util.Arrays;

/**
 * https://leetcode.com/problems/longest-increasing-subsequence/description/
 */
public class LongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int prev = Integer.MIN_VALUE;

        return solve(nums, 0, prev, dp);
    }

    public static int solve(int[] nums, int idx, int prev, int[][] dp) {
        if (idx >= nums.length) return 0;
        if(prev != Integer.MIN_VALUE && dp[idx][prev] != -1) return dp[idx][prev];

        int ans;
        if ((prev == Integer.MIN_VALUE? Integer.MIN_VALUE: nums[prev]) < nums[idx]) {
            int ans1 = 1 + solve(nums, idx + 1, idx, dp);
            int ans2 = solve(nums, idx + 1, prev, dp);
            ans = Math.max(ans1, ans2);
        } else {
            ans = solve(nums, idx + 1, prev, dp);
        }

        if(prev != Integer.MIN_VALUE) {
            return dp[idx][prev] = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(LongestIncreasingSubsequence.lengthOfLIS(new int[]{-2, -1}));
    }

}
