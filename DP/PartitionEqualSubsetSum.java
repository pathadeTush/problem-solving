import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-equal-subset-sum/
 */
public class PartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        int n = nums.length;

        int[][] dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, 0, sum, 0, n, dp);
    }

    public static boolean solve(int[] nums, int idx, int sum, int subSum, int n, int[][] dp) {
        if (sum - subSum == subSum) return true;
        if (idx >= n) return false;

        if (dp[idx][subSum] != -1) return dp[idx][subSum] == 1;

        boolean ans1 = solve(nums, idx + 1, sum, subSum + nums[idx], n, dp);
        boolean ans2 = solve(nums, idx + 1, sum, subSum, n, dp);

        dp[idx][subSum] = (ans1 || ans2) ? 1 : 0;
        return ans1 || ans2;
    }

    public static void main(String[] args) {
        System.out.println(PartitionEqualSubsetSum.canPartition(new int[]{1, 2, 3, 5, 5}));
    }

}
