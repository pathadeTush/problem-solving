/**
 * https://leetcode.com/problems/find-peak-element/description/
 */
public class FindPeakElements_162 {

    /*
    nums = {1,2,1,3,5,6,4}

    l = 0, r = 3, mid = 1

     */
    public static int findPeakElement(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = n-1;

        while (l <= r) {
            int mid = (l+r) >> 1;
            if((mid-1 < 0 || nums[mid-1] < nums[mid]) && (mid+1 >= n || nums[mid] > nums[mid+1])) {
                return mid;
            }
            if((mid - 1 < 0 || nums[mid - 1] < nums[mid]) && (mid + 1 >= n || nums[mid] < nums[mid + 1])) {
                l = mid+1;
            } else {
                r = mid-1;
            }
        }

        return l;
    }

    public static void main(String[] args) {
//        int[] nums = {1,2,3,1};
//        int[] nums = {1,2,1,3,5,6,4};
//        int[] nums = {1,2};
        int[] nums = {1,2,3,4};
        System.out.println(FindPeakElements_162.findPeakElement(nums));
    }

}
