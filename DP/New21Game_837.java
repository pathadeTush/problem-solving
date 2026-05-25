import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * https://leetcode.com/problems/new-21-game/description/
 */
public class New21Game_837 {

    public static double new21Game(int n, int k, int maxPts) {
        double[] dp = new double[n+1];
        return Math.round(solve(n, k, maxPts, 0, dp)*1e5)/(double)1e5;
    }

    private static double solve(int n, int k, int maxPts, int points, double[] dp) {
        if (points >= k) {
            return 1;
        }
        if(dp[points] != 0) {
            return dp[points];
        }

        double rate = (double) 1/maxPts;
        double prob = 0;
        for (int i = 1; i <= maxPts; i++) {
            if(prob != 0 && 0l == Math.floor(1e9*prob)) {
                break;
            }
            if(points+i <= n) {
                prob += rate * solve(n, k, maxPts, points + i, dp);
            } else {
                break;
            }
        }

        return dp[points] = prob;
    }

    public static void main(String[] args) {
//        int n = 10, k = 1, maxPts = 10;
//        int n = 6, k = 1, maxPts = 10;
        int n = 21, k = 17, maxPts = 10;
        System.out.println(New21Game_837.new21Game(n, k, maxPts));
    }

}
