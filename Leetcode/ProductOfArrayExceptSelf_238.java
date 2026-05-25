/**
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ProductOfArrayExceptSelf_238 {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int zeroIndex = -1;
        int product = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                product *= nums[i];
            }
        }
        if (zeroCount > 1) {
            return new int[n];
        }
        if (zeroCount == 1) {
            int[] arr = new int[n];
            arr[zeroIndex] = product;
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if(nums[i] == 0) continue;
            ans[i] = (int)(product * Math.pow(nums[i], -1));
        }
        return ans;
    }

}
