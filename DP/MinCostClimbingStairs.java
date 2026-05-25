import java.util.Arrays;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/
 */
public class MinCostClimbingStairs {

//    public static int minCostClimbingStairs(int[] cost) {
//        int n = cost.length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, -1);
//        return Math.min(solve(cost, 0, dp), solve(cost, 1, dp));
//    }
//
//    public static int solve(int[] cost, int idx, int[] dp) {
//        if(idx >= cost.length) {
//            return 0;
//        }
//        if(dp[idx] != -1) return dp[idx];
//
//        int firstStep = solve(cost, idx+1, dp);
//        int secondStep = solve(cost, idx+2, dp);
//
//        return dp[idx] = cost[idx] + Math.min(firstStep, secondStep);
//    }

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n < 2) {
            return cost[0];
        }
        if(n < 3) {
            return Math.min(cost[0], cost[1]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];

        for(int i = n-3; i >= 0; i--) {
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }

    public static void main(String[] args) {
        System.out.println(MinCostClimbingStairs.minCostClimbingStairs(new int[]{1,100,1,1,1,100,1,1,100,1}));
    }

}
