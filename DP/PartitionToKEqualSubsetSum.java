import java.util.Arrays;

/**
 * https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
 */
public class PartitionToKEqualSubsetSum {
    // 2^(kxn) solution
    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
        }
        if(sum%k != 0) {
            return false;
        }
        int targetSum = sum/k;
        boolean[] vis = new boolean[n];
        Arrays.sort(nums);
        return solve(0, nums, k, targetSum, 0, vis);
    }

    public static boolean solve(int idx, int[] nums, int k, int targetSum, int subsetSum, boolean[] vis) {
        int n = nums.length;
        if(k == 0) {
            return true;
        }
        if(subsetSum == targetSum) {
            return solve(0, nums, k-1, targetSum, 0, vis);
        }

        for(int i = idx; i < n; i++) {
            if(vis[i]) {
                continue;
            }
            if(subsetSum + nums[i] > targetSum) {
                break;
            }

            vis[i] = true;
            if(solve(i+1, nums, k, targetSum,subsetSum+nums[i], vis)) {
                return true;
            }
            vis[i] = false;
        }

        return false;
    }


    // K^n solution
//    public static boolean canPartitionKSubsets(int[] nums, int k) {
//        int n = nums.length;
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += nums[i];
//        }
//        if (sum % k != 0) {
//            return false;
//        }
//        int targetSum = sum / k;
//        int[] subsetSum = new int[k];
//
//        return solve(0, n, subsetSum, nums, targetSum);
//    }
//
//    public static boolean solve(int idx, int n, int[] subsetSum, int[] nums, int targetSum) {
//        if(idx >= n) {
//            return checkIfAllSumEqualTargetSum(subsetSum, targetSum);
//        }
//
//        int k = subsetSum.length;
//        for(int i = 0; i < k; i++) {
//            if(subsetSum[i] + nums[idx] > targetSum) {
//                continue;
//            }
//            subsetSum[i] += nums[idx];
//            boolean ans = solve(idx+1, n, subsetSum, nums, targetSum);
//            if(ans) {
//                return true;
//            }
//
//            subsetSum[i] -= nums[idx];
//        }
//
//        return false;
//    }
//
//    public static boolean checkIfAllSumEqualTargetSum(int[] subsetSum, int targetSum) {
//        int k = subsetSum.length;
//        for(int i = 0; i < k; i++) {
//            if(subsetSum[i] != targetSum) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 4, 6, 2, 3, 8, 10, 2, 10, 7};
        int k = 4;
        System.out.println(PartitionToKEqualSubsetSum.canPartitionKSubsets(nums, k));
    }

}
