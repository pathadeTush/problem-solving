import java.util.Arrays;

/**
 * problem: https://leetcode.com/problems/climbing-stairs/
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return solve(0, dp, n);
    }

    public static int solve(int idx, int[] dp, int n) {
        if(idx == n) return 1;
        if(idx > n) return 0;

        if(dp[idx] != -1) return dp[idx];

        int step1 = 0;
        int step2 = 0;
        if(idx+1 <= n) {
            step1 = solve(idx+1, dp, n);
        }
        if(idx+2 <= n) {
            step2 = solve(idx+2, dp, n);
        }

        dp[idx] = step1+step2;
        return dp[idx];
    }

    public static void main(String[] args) {
        System.out.println(ClimbingStairs.climbStairs(4));
    }

}
