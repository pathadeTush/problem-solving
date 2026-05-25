/**
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
 */
public class MinNoDaysToMakeMBouquets_1482 {

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) {
            return -1;
        }
        int l = 0;
        int r = 0;
        for (int day : bloomDay) {
            r = Math.max(r, day);
        }

        int ans = -1;
        while (l <= r) {
            int mid = l - (l - r) / 2;
            boolean possible = isPossible(bloomDay, m, k, mid);
            if (possible) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] bloomDay, int m, int k, int mid) {
        int n = bloomDay.length;
        int adjCount = 0;
        int bouquetCunt = 0;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] - mid <= 0) {
                adjCount++;
            } else {
                adjCount = 0;
            }
            if (adjCount == k) {
                bouquetCunt++;
                adjCount = 0;
            }

            if (bouquetCunt >= m) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] bloomDay = new int[]{1, 10, 3, 10, 2};
//        int m = 3, k = 1;
//        int[] bloomDay = new int[]{1,10,3,10,2};
//        int m = 3, k = 2;
        int[] bloomDay = new int[]{7, 7, 7, 7, 12, 7, 7};
        int m = 2, k = 3;
        System.out.println(MinNoDaysToMakeMBouquets_1482.minDays(bloomDay, m, k));
    }

}
