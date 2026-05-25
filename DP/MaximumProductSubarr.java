import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-product-subarray/
 */
public class MaximumProductSubarr {

    public static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProd = Integer.MIN_VALUE;
        int prod = 1;
        for(int i = 0; i < n; i++) {
            prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
            if(prod == 0) {
                prod = 1;
            }
        }

        prod = 1;
        for(int i = n-1; i >= 0; i--) {
            prod *= nums[i];
            maxProd = Math.max(maxProd, prod);
            if(prod == 0) {
                prod = 1;
            }
        }

        return maxProd;
    }

    public static void main(String[] args) {
        System.out.println(MaximumProductSubarr.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(MaximumProductSubarr.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(MaximumProductSubarr.maxProduct(new int[]{-2, 3, -2, -4}));
    }

}
