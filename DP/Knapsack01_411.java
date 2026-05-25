import java.util.Arrays;

public class Knapsack01_411 {

    public static void main(String[] args) {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 2, 3};
        int w = 5;
        System.out.println(knapsack(w, val, wt));
    }

    static int knapsack(int w, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[w + 1][n];
        for (int i = 0; i < w + 1; i++) {
            Arrays.fill(dp[i], -1);
        }

//        return solve(w, val, wt, 0, dp);
        return solveIterative(w, val, wt);
    }

    public static int solve(int w, int val[], int wt[], int idx, int[][] dp) {
        if (w < 0) {
            return 0;
        }
        if (idx >= wt.length) {
            return 0;
        }
        if (dp[w][idx] != -1) {
            return dp[w][idx];
        }

        int ans;
        if (w - wt[idx] >= 0) {
            // take
            int take = val[idx] + solve(w - wt[idx], val, wt, idx + 1, dp);
            // not take
            int notTake = solve(w, val, wt, idx + 1, dp);
            ans = Math.max(take, notTake);
        } else {
            // not take
            ans = solve(w, val, wt, idx + 1, dp);
        }

        return dp[w][idx] = ans;
    }

    public static int solveIterative(int w, int val[], int wt[]) {
        int n = val.length;
        int[][] dp = new int[w+1][n+1];

        for(int weight = 0; weight < w+1; weight++) {
            for(int j = 0; j < n+1; j++) {
                if(weight == 0 || j == 0) {
                    dp[weight][j] = 0;
                    continue;
                }

                int ans = 0;
                if(weight - wt[j-1] >= 0) {
                    ans = Math.max(val[j-1] + dp[weight - wt[j-1]][j-1], dp[weight][j-1]);
                } else {
                    ans = dp[weight][j-1];
                }

                dp[weight][j] = ans;
            }
        }

        return dp[w][n];
    }

}
