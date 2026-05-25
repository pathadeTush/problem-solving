public class FindMinInRotatedSortedArray {

    // Problem: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/

    public static void main(String[] args) {
        int[] nums = new int[]{3,0,1,2};
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = (i + j) >> 1;
            boolean isPivotRightSide = nums[mid] > nums[j];

            if(i == j) {
                return nums[i];
            }
            // pivot is the minimum
            if(isPivotRightSide) {
                i = mid+1;
            } else {
                j = mid;
            }
        }

        return -1;
    }

}
