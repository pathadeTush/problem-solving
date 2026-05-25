import java.util.Arrays;

/**
 * https://leetcode.com/problems/house-robber/
 */

public class HouseRobber {

    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, nums, n, dp);
    }

    public static int solve(int idx, int[] nums, int n, int[] dp) {
        if(idx >= n) return 0;
        if(dp[idx] != -1) {
            return dp[idx];
        }

        // take
        int take = nums[idx] + solve(idx+2, nums, n, dp);
        // not take
        int notTake = solve(idx+1, nums, n, dp);

        return dp[idx] = Math.max(take, notTake);
    }

    public static void main(String[] args) {
        System.out.println(HouseRobber.rob(new int [] {5, 4, 3, 4}));
    }

}
