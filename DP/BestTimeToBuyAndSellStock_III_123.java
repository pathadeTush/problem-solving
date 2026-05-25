import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
 */
public class BestTimeToBuyAndSellStock_III_123 {

    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][2];
        for(int i = 0; i < n; i++) {
            Arrays.fill(dp[i][0], -1);
            Arrays.fill(dp[i][1], -1);
        }
        return solve(prices, 0, 0, dp, 0);
    }

    private static int solve(int[] prices, int holdingStock, int idx, int[][][] dp, int traxn) {
        int n = prices.length;
        if (idx >= n || traxn >= 2) {
            return 0;
        }
        if(dp[idx][holdingStock][traxn] != -1) {
            return dp[idx][holdingStock][traxn];
        }

        int ans = 0;
        if (holdingStock == 1) {
            // sell
            int sell = prices[idx] + solve(prices, 0, idx+1, dp, traxn+1);
            // hold
            int hold = solve(prices, holdingStock, idx+1, dp, traxn);
            ans = Math.max(sell, hold);
        } else {
            // buy
            int buy = -prices[idx] + solve(prices, 1, idx+1, dp, traxn);
            // don't buy
            int dontBuy = solve(prices, 0, idx+1, dp, traxn);
            ans = Math.max(buy, dontBuy);
        }

        return dp[idx][holdingStock][traxn] = ans;
    }

    public static void main(String[] args) {
//        int[] prices = new int[]{1,2,3,0,2};
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(BestTimeToBuyAndSellStock_III_123.maxProfit(prices));
    }

}
