import java.util.Arrays;

public class WordWrap_68 {

    public static int solve(int[] nums, int k, int idx, int remSpace, int[][] dp) {
        if (idx >= nums.length) {
            return 0;
        }

        if (dp[idx][remSpace] != -1) {
            return dp[idx][remSpace];
        }

        int cost;
        if (nums[idx] + 1 > remSpace) {
            // keep it in new line
            cost = remSpace * remSpace + solve(nums, k, idx + 1, k - nums[idx], dp);
        } else {
            // keep it in same line
            int cost1 = solve(nums, k, idx + 1, remSpace - (nums[idx] + 1), dp);
            // keep it in new line
            int cost2 = remSpace * remSpace + solve(nums, k, idx + 1, k - nums[idx], dp);

            cost = Math.min(cost1, cost2);
        }

        return dp[idx][remSpace] = cost;
    }

    public static int solveWordWrap(int[] nums, int k) {
        if (nums.length < 1) {
            return 0;
        }
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(nums, k, 1, k - nums[0], dp);
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2};
        int k = 4;
        System.out.println(solveWordWrap(nums, k));
    }

}
