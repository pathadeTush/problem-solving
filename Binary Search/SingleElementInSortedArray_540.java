/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInSortedArray_540 {

    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (l == r) {
                return nums[l];
            }
            if (mid % 2 == 0) {
                // same ele should appear on right
                if (nums[mid] == nums[mid + 1]) {
                    l = mid + 1;
                } else {
                    if(nums[mid] == nums[mid-1]) {
                        r = mid-1;
                    } else {
                        return nums[mid];
                    }
//                    r = mid;
                }
            } else {
                // same ele should appear on left
                if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    if(nums[mid] == nums[mid+1]) {
                        r = mid-1;
                    } else {
                        return nums[mid];
                    }
//                    r = mid;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,3};
        System.out.println(SingleElementInSortedArray_540.singleNonDuplicate(nums));
    }

}
