/**
 * https://leetcode.com/problems/kth-missing-positive-number/
 */
public class KthMissingPositiveNumber_1539 {

    public static int findKthPositive(int[] arr, int k) {
        int n = arr.length;

        int l = 0;
        int r = n - 1;
        while (l <= r) {
            int mid = (l + r) >> 1;
            int missingCount = arr[mid] - (mid + 1);
            if (missingCount == 0) {
                l = mid + 1;
            } else if (missingCount > k) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if(r < 0) {
            return k;
        }
        int missingCount = arr[r] - (r + 1);
        if(missingCount < k) {
            return arr[r] + k - missingCount;
        }

        while (missingCount >= k) {
            r--;
            if(r < 0) {
                break;
            }
            missingCount = arr[r]-(r+1);
        }

        if(r >= 0) {
            return arr[r] + k - missingCount;
        } else {
            return k;
        }
    }

    public static int findKthPositive_BruteForce(int[] arr, int k) {
        int n = arr.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            if (arr[i] >= ans) {
                ans++;
            } else {
                break;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{2, 3, 4, 7, 11};
//        int k = 5;
//        int[] arr = new int[]{1, 2, 3, 4};
//        int k = 2;
        int[] arr = new int[]{2};
        int k = 1;
        System.out.println(KthMissingPositiveNumber_1539.findKthPositive(arr, k));
    }

}
