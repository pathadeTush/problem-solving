import java.util.Arrays;

public class BuyAndSellStockII_31 {

    /*
    * TC: O(n*2*3) ~ O(n)
    *  */
    public static int maxProfit(int n, int[] price, int idx, int toBuy, int totalTransaction, int[][][] dp) {
        if (idx >= n || totalTransaction >= 2) {
            return 0;
        }

        if(dp[idx][toBuy][totalTransaction] != -1) {
            return dp[idx][toBuy][totalTransaction];
        }

        // to buy
        int maxProfit = 0;
        if (toBuy == 1) {
            // buy
            int profitWithBuy = -price[idx] + maxProfit(n, price, idx+1, 0, totalTransaction, dp);
            // not buy
            int profitWithNoBuy = maxProfit(n, price, idx+1, 1, totalTransaction, dp);

            maxProfit = Math.max(profitWithBuy, profitWithNoBuy);
        }
        // to sell
        else {
            // sell
            int profitWithSell = price[idx] + maxProfit(n, price, idx+1, 1, totalTransaction+1, dp);
            // not sell
            int profitWithNoSell = maxProfit(n, price, idx+1, 0, totalTransaction, dp);

            maxProfit = Math.max(profitWithSell, profitWithNoSell);
        }

        return dp[idx][toBuy][totalTransaction] = maxProfit;
    }

    public static int maxProfit(int n, int[] price) {
        if(n < 2) {
            return 0;
        }

        int[][][] dp = new int[n][2][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return maxProfit(n, price, 0, 1, 0, dp);
    }

    public static void main(String[] args) {
        int[] price = {10};
        System.out.println(maxProfit(price.length, price));
    }

}
