/**
 * https://leetcode.com/problems/maximum-sum-circular-subarray/description/
 */
public class MaxSumCircularSubArr {

//    public static int maxSubarraySumCircular(int[] nums) {
//        int n = nums.length;
//        int ans = Integer.MIN_VALUE;
//        for(int i = 0; i < n; i++) {
//            int sum = 0;
//            for(int j = i; j < n; j++) {
//                sum += nums[j];
//                ans = Math.max(ans, sum);
//            }
//            for(int j = 0; j < i; j++) {
//                sum += nums[j];
//                ans = Math.max(ans, sum);
//            }
//        }
//
//        return ans;
//    }

    public static int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        int[] maxPrefixSum = new int[n];
        int prefixSum = 0;
        int maxPrefSum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            prefixSum += nums[i];
            ans = Math.max(ans, sum);
            if(sum < 0) {
                sum = 0;
            }
            maxPrefSum = Math.max(maxPrefSum, prefixSum);
            maxPrefixSum[i] = maxPrefSum;
        }

        sum = 0;
        for (int i = n-1; i > 0; i--) {
            sum += nums[i];
            ans = Math.max(ans, sum + maxPrefixSum[i-1]);
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(MaxSumCircularSubArr.maxSubarraySumCircular(new int[]{1, -2, 3, -2}));
        System.out.println(MaxSumCircularSubArr.maxSubarraySumCircular(new int[]{-2, 2, 2, -2, 9}));
        System.out.println(MaxSumCircularSubArr.maxSubarraySumCircular(new int[]{4, -2, 1, -2, -3, 1}));
    }

}
