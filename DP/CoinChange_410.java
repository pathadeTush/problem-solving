import java.util.Arrays;

public class CoinChange_410 {

    public static void main(String[] args) {
        int[] a = {2, 5, 3, 6};
        int n = a.length;
        int sum = 10;
        int[][] dp = new int[sum][n];
        for (int i = 0; i < sum; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(count(a, sum, 0, 0, dp));
    }

    public static int count(int coins[], int sum, int combSum, int idx, int[][] dp) {
        if (combSum == sum) {
            return 1;
        }
        if (idx >= coins.length || combSum > sum) {
            return 0;
        }
        if(dp[combSum][idx] != -1) {
            return dp[combSum][idx];
        }

        int ans = 0;
        // If sum less than, take or not take
        if (combSum + coins[idx] <= sum) {
            //take and you can still take same element in future, so IDX
            ans += count(coins, sum, combSum + coins[idx], idx, dp);

            // not take
            ans += count(coins, sum, combSum, idx+1, dp);
        } else {
            // not take
            ans += count(coins, sum, combSum, idx+1, dp);
        }
        return dp[combSum][idx] = ans;
    }

}
