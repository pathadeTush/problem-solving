/**
 * https://leetcode.com/problems/fair-distribution-of-cookies/description/
 */
public class FairDistributionOfCookies_2305 {

    public static int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;

        int[] cookiesAssigned = new int[k];

        int[] ans = new int[]{Integer.MAX_VALUE};
        solve(cookies, cookiesAssigned, n, k, 0, ans);
        return ans[0];
    }

    private static void solve(int[] cookies, int[] cookiesAssigned, int n, int k, int idx, int[] ans) {
        if (idx == n) {
            //calculate
            updateAns(cookiesAssigned, k, ans);
            return;
        }

        for (int i = 0; i < k; i++) {
            cookiesAssigned[i] += cookies[idx];
            solve(cookies, cookiesAssigned, n, k, idx + 1, ans);
            cookiesAssigned[i] -= cookies[idx];
            if(cookiesAssigned[i] == 0) {
                break;
            }
        }
    }

    private static void updateAns(int[] cookiesAssigned, int k, int[] ans) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            maxValue = Math.max(maxValue, cookiesAssigned[i]);
            minValue = Math.min(minValue, cookiesAssigned[i]);
        }

        ans[0] = Math.min(ans[0], maxValue);
    }

    public static void main(String[] args) {
//        int[] cookies = new int[] {8,15,10,20,8};
//        int k = 2;
//        int[] cookies = new int[] {6,1,3,2,2,4,1,2};
//        int k = 3;
        int[] cookies = new int[]{941, 797, 1475, 638, 191, 712};
        int k = 3;
        System.out.println(FairDistributionOfCookies_2305.distributeCookies(cookies, k));
    }

}
