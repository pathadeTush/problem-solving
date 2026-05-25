/**
 * https://leetcode.com/problems/koko-eating-bananas/description/
 */
public class KokoEatingBananas_875 {

    public static int minEatingSpeed(int[] piles, int h) {
        int l = 0;
        int r = 0;
        int n = piles.length;
        for (int i = 0; i < n; i++) {
            r = Math.max(r, piles[i]);
        }

        int ans = r;
        while (l <= r) {
            int mid = l - ((l-r) >> 1);
            boolean possible = isPossible(piles, h, mid, n);
            if (possible) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] piles, int h, int mid, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += (int) Math.ceil((double) piles[i] / mid);
            if (count > h) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] piles = new int[]{3, 6, 7, 11};
//        int h = 8;
//        int[] piles = new int[]{30,11,23,4,20};
//        int h = 5;
//        int[] piles = new int[]{30,11,23,4,20};
//        int h = 6;
        int[] piles = new int[]{312884470};
        int h = 312884469;
        System.out.println(KokoEatingBananas_875.minEatingSpeed(piles, h));
    }

}
