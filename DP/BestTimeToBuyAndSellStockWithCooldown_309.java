import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
 */
public class BestTimeToBuyAndSellStockWithCooldown_309 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(prices, 0, 0, dp);
    }

    private static int solve(int[] prices, int holdingStock, int idx, int[][] dp) {
        int n = prices.length;
        if (idx >= n) {
            return 0;
        }
        if(dp[idx][holdingStock] != -1) {
            return dp[idx][holdingStock];
        }

        int ans = 0;
        if (holdingStock == 1) {
            // sell
            int sell = prices[idx] + solve(prices, 0, idx+2, dp);
            // hold
            int hold = solve(prices, holdingStock, idx+1, dp);
            ans = Math.max(sell, hold);
        } else {
            // buy
            int buy = -prices[idx] + solve(prices, 1, idx+1, dp);
            // don't buy
            int dontBuy = solve(prices, 0, idx+1, dp);
            ans = Math.max(buy, dontBuy);
        }

        return dp[idx][holdingStock] = ans;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{1,2,3,0,2};
        int[] prices = new int[]{1, 0};
        System.out.println(BestTimeToBuyAndSellStockWithCooldown_309.maxProfit(prices));
    }

}
