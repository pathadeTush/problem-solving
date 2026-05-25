public class BuyAndSellStock_22 {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int len = prices.length;
        int maxPrice = prices[len-1];
        for(int i = len-2; i >= 0; i--) {
            if(prices[i] < maxPrice) {
                maxProfit = Math.max(maxProfit, maxPrice - prices[i]);
            } else {
                maxPrice = prices[i];
            }
        }

        return maxProfit;
    }

}
