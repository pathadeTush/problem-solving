import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/description/
 */
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        long[] dp = new long[amount+1];
        Arrays.fill(dp, 0);

        int ans = solve(coins, amount, 0, n, 0, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static int solve(int[] coins, int amount, int idx, int n, int sum, long[] dp) {
        if (sum == amount) {
            return 0;
        }
        if (sum > amount) {
            return Integer.MAX_VALUE;
        }
        if (idx >= n) {
            return Integer.MAX_VALUE;
        }

        if(dp[sum] != 0) {
            return (int) dp[sum];
        }

        int ans;
        long _sum  = (long) sum + (long) coins[idx];
        if (_sum <= amount) {
            int take = solve(coins, amount, idx, n, sum + coins[idx], dp);
            int notTake = solve(coins, amount, idx + 1, n, sum, dp);
            if(take != Integer.MAX_VALUE) {
                take++;
            }
            ans = Math.min(take, notTake);
        } else {
            ans = solve(coins, amount, idx + 1, n, sum, dp);
        }

        return (int) (dp[sum] = ans);
    }

    public static void main(String[] args) {
        System.out.println(CoinChange.coinChange(new int[]{1, 2, 5}, 11));
    }

}
