/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */
public class SearchInRotatedSortedArr_ll {

    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        boolean isPivotLeftSide;
        while (l <= r) {
            int mid = (l+r) >> 1;
            if(nums[mid] == target) {
                return true;
            }

            if(nums[l] == nums[mid] && nums[mid] == nums[r]) {
                l = l+1;
                r = r-1;
                continue;
            }
            isPivotLeftSide = nums[mid] <= nums[r];
            if(nums[mid] > target) {
                if(isPivotLeftSide) {
                    r = mid-1;
                } else {
                    if(nums[r] < target) {
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                }
            } else {
                if(isPivotLeftSide) {
                    if(nums[r] < target) {
                        r = mid-1;
                    } else {
                        l = mid+1;
                    }
                } else {
                    l = mid+1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        int[] nums = new int[] {4,5,6,7,0,1,2};
//        int target = 0;
//        int[] nums = new int[] {4,5,6,7,0,1,2};
//        int target = 3;
        int[] nums = new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int target = 2;
        System.out.println(SearchInRotatedSortedArr_ll.search(nums, target));
    }

}
