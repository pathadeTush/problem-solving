/**
 * https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1
 */
public class KthElementOf2SortedArrays {

    public static int kthElement(int a[], int b[], int k) {
        int m = a.length;
        int n = b.length;

        if (m > n) {
            return kthElement(b, a, k);
        }

        int low = Math.max(0, k-n), high = Math.min(m, k);
        while (low <= high) {
            int mid1 = low- (low-high)/2; // ele to take from a
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            int mid2 = k - mid1; // ele to take from b
            if (mid1 < m) r1 = a[mid1];
            if (mid2 < n) r2 = b[mid2];
            if (mid1 - 1 >= 0) l1 = a[mid1 - 1];
            if (mid2 - 1 >= 0) l2 = b[mid2 - 1];
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            if(l1 > r2) {
                high = mid1-1;
            } else {
                low = mid1+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] a = new int[]{2, 3, 6, 7, 9};
//        int[] b = new int[]{1, 4, 8, 10};
//        int k = 5;
        int[] a = new int[]{1, 4, 8, 10, 12};
        int[] b = new int[]{5, 7, 11, 15, 17};
        int k = 6;
        System.out.println(KthElementOf2SortedArrays.kthElement(a, b, k));
    }

}
