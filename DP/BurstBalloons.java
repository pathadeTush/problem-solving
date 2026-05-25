/**
 * https://leetcode.com/problems/burst-balloons/description/
 * <p>
 * https://www.youtube.com/watch?v=VFskby7lUbw
 */
public class BurstBalloons {

    public static int maxCoins(int[] nums) {
        int n = nums.length;
        int[] extendedNums = new int[n+2];
        extendedNums[0] = 1;
        extendedNums[n+1] = 1;
        for(int i = 0; i < n; i++) {
            extendedNums[i+1] = nums[i];
        }
        int[][] dp = new int[n+1][n+1];
        return solve(extendedNums, 1, n, dp);
    }

    private static int solve(int[] extendedNums, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if(dp[i][j] != 0) {
            return dp[i][j];
        }

        int ans = Integer.MIN_VALUE;
        for (int k = i; k <= j; k++) {
            int tempAns = extendedNums[i-1]*extendedNums[k]*extendedNums[j+1] + solve(extendedNums, i, k - 1, dp) + solve(extendedNums, k + 1, j, dp);
            ans = Math.max(ans, tempAns);
        }

        return dp[i][j] = ans;
    }

    /*
    Bruteforce: n^2*(2^n)
     */
//    public static int maxCoins(int[] nums) {
//        int n = nums.length;
//        boolean[] vis = new boolean[n];
//        return solve(nums, vis, 0);
//    }
//
//    private static int solve(int[] nums, boolean[] vis, int count) {
//        if (count >= nums.length) {
//            return 0;
//        }
//
//        int ans = Integer.MIN_VALUE;
//
//        for (int i = 0; i < nums.length; i++) {
//            if (vis[i]) continue;
//
//            vis[i] = true;
//            int tempAns = calculateCoins(nums, vis, i) + solve(nums, vis, count + 1);
//            vis[i] = false;
//
//            ans = Math.max(ans, tempAns);
//        }
//
//        return ans;
//    }
//
//    private static int calculateCoins(int[] nums, boolean[] vis, int idx) {
//        int leftIdxOfBalloon = idx-1;
//        while (leftIdxOfBalloon >= 0 && vis[leftIdxOfBalloon]) {
//            leftIdxOfBalloon--;
//        }
//
//        int rightIdxOfBalloon = idx+1;
//        while (rightIdxOfBalloon < nums.length && vis[rightIdxOfBalloon]) {
//            rightIdxOfBalloon++;
//        }
//
//        int cost = nums[idx];
//        if(leftIdxOfBalloon >= 0) {
//            cost = cost * nums[leftIdxOfBalloon];
//        }
//        if(rightIdxOfBalloon < nums.length) {
//            cost = cost * nums[rightIdxOfBalloon];
//        }
//        return cost;
//    }
//
    public static void main(String[] args) {
        int[] nums = new int[]{3, 1, 5, 8};
//        int[] nums = new int[] {1, 5};
        System.out.println(BurstBalloons.maxCoins(nums));
    }

}
