import java.util.Arrays;

/**
 * https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
 */
public class CheapestFlightsWithinKStops {

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        boolean[] vis = new boolean[n];
        vis[src] = true;
        int[][][] dp = new int[n][n][k+2];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        int cheapestCost = solve(flights, src, dst, k+1, vis, src, dp);
        return cheapestCost == Integer.MAX_VALUE ? -1 : cheapestCost;
    }

    private static int solve(int[][] flights, int src, int dst, int k, boolean[] vis, int prev, int[][][] dp) {
        if (k < 0) {
            return Integer.MAX_VALUE;
        }
        if (src == dst) {
            return 0;
        }
        if(dp[src][prev][k] != -1) {
            return dp[src][prev][k];
        }

        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            if (u == src && !vis[v]) {
                vis[v] = true;
                int ans = solve(flights, v, dst, k - 1, vis, u, dp);
                if (ans != Integer.MAX_VALUE) {
                    cost = Math.min(cost, ans + flights[i][2]);
                }
                vis[v] = false;
            }
        }

        return dp[src][prev][k] = cost;
    }

    public static void main(String[] args) {
//        int[][] flights = new int[][]{
//                {0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}
//        };
//        int n = 4;
//        int k = 1, src = 0, dst = 3;

//        int[][] flights = new int[][]{{1, 2, 10}, {2, 0, 7}, {1, 3, 8}, {4, 0, 10}, {3, 4, 2}, {4, 2, 10}, {0, 3, 3}, {3, 1, 6}, {2, 4, 5}};
//        int n = 5;
//        int k = 1, src = 0, dst = 4;

        int[][] flights = new int[][]{{0,1,100},{0,2,100},{0,3,10},{1,2,100},{1,4,10},{2,1,10},{2,3,100},{2,4,100},{3,2,10},{3,4,100}};
        int n = 5;
        int k = 3, src = 0, dst = 4;
        System.out.println(CheapestFlightsWithinKStops.findCheapestPrice(n, flights, src, dst, k));
    }

}
