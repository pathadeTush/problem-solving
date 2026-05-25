public class SearchInRotatedSortedArray {

    // Problem: https://leetcode.com/problems/search-in-rotated-sorted-array/

    public static void main(String[] args) {
        int[] nums = new int[] {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int i = 0, j = nums.length-1;

        while (i <= j) {
            int mid = (i+j) >> 1;
            boolean isPivotLeftSide = nums[mid] <= nums[j];

            if(nums[mid] == target) {
                return mid;
            } else if(target < nums[mid]) {
                // pivot is in left side
                if(isPivotLeftSide) {
                    j = mid-1;
                } else {
                    if(target < nums[i]) {
                        i = mid+1;
                    } else {
                        j = mid-1;
                    }
                }
            } else {
                if(isPivotLeftSide) {
                    if(target <= nums[j]) {
                        i = mid+1;
                    } else {
                        j = mid-1;
                    }
                } else {
                    i = mid+1;
                }
            }
        }

        return -1;
    }

}
