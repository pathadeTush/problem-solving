import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenSum_23 {

    /*
     * Brute force DP TC: O(2^n)
     * */
    public static int getPairsCount_BruteForce(int[] arr, int sum, int idx, int pairSum, int pendingNum) {
        if (pairSum == sum && pendingNum == 0) {
            return 1;
        }
        if (pairSum > sum || pendingNum == 0 || idx >= arr.length) {
            return 0;
        }

        int ans = 0;
        // take
        ans += getPairsCount_BruteForce(arr, sum, idx + 1, pairSum + arr[idx], pendingNum - 1);
        // not take
        ans += getPairsCount_BruteForce(arr, sum, idx + 1, pairSum, pendingNum);

        return ans;
    }

    /*
     * Using DP, TC: O(n*sum*3) ~ O(n^2)
     * */
    public static int getPairsCount_DP(int[] arr, int sum, int idx, int pairSum, int pendingNum, int[][][] dp) {
        if (pairSum == sum && pendingNum == 0) {
            return 1;
        }
        if (pairSum > sum || pendingNum == 0 || idx >= arr.length) {
            return 0;
        }
        if (dp[idx][pairSum][pendingNum] != -1) {
            return dp[idx][pairSum][pendingNum];
        }

        int ans = 0;
        // take
        ans += getPairsCount_DP(arr, sum, idx + 1, pairSum + arr[idx], pendingNum - 1, dp);
        // not take
        ans += getPairsCount_DP(arr, sum, idx + 1, pairSum, pendingNum, dp);

        return dp[idx][pairSum][pendingNum] = ans;
    }

    /*
     * Optimized TC: O(n) SC: O(n)
     *
     * a+b = sum
     * a = sum-b
     *
     * find how many a available which are equal to sum-b
     * */
    public static int getPairsCount(int[] arr, int sum) {
        Map<Integer, Integer> eleFreqMap = new HashMap<>();
        for (int k : arr) {
            eleFreqMap.put(k, eleFreqMap.getOrDefault(k, 0) + 1);
        }

        int count = 0;
        for (int j : arr) {
            count += eleFreqMap.getOrDefault(sum - j, 0);
            if (j * 2 == sum) {
                count--;
            }
        }

        return count >> 1; // Half because, for b, a is counted and for a, b is counted, Hence counted twice
    }

}
