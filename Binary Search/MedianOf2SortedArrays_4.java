/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 */
public class MedianOf2SortedArrays_4 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = -1;
        int val1 = 0;
        int val2 = 0;
        boolean isEven = (m + n) % 2 == 0;
        int i = 0, j = 0;
        int val;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                val = nums1[i];
                i++;
            } else {
                val = nums2[j];
                j++;
            }
            k++;
            if (k == (m + n) / 2) {
                val1 = val;
                if(!isEven) break;
            }
            if (isEven && k == ((m + n) / 2 - 1)) {
                val2 = val;
            }
        }

        while (i < m) {
            val = nums1[i];
            i++;
            k++;
            if (k == (m + n) / 2) {
                val1 = val;
                if(!isEven) break;
            }
            if (isEven && k == ((m + n) / 2 - 1)) {
                val2 = val;
            }
        }

        while (j < n) {
            val = nums2[j];
            j++;
            k++;
            if (k == ((m + n) / 2)) {
                val1 = val;
                if(!isEven) break;
            }
            if (isEven && k == ((m + n) / 2 - 1)) {
                val2 = val;
            }
        }

        if (isEven) {
            return (val1 + val2) / 2.0;
        }

        return val1;
    }

    public static void main(String[] args) {
//        int[] nums1 = new int[]{1, 3};
//        int[] nums2 = new int[]{2};
        int[] nums1 = new int[]{};
        int[] nums2 = new int[]{};
        System.out.println(MedianOf2SortedArrays_4.findMedianSortedArrays(nums1, nums2));
    }

}
