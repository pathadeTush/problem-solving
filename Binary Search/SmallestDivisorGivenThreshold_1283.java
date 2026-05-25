/**
 * https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
 */
public class SmallestDivisorGivenThreshold_1283 {

    public static int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = 1;
        for(int num: nums) {
            r = Math.max(r, num);
        }

        int ans = -1;
        while (l <= r) {
            int mid = l - ((l-r)>>1);
            int sum = sum(nums, mid);
            if(sum <= threshold) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return ans;
    }

    private static int sum(int[] nums, int divisor) {
        int sum = 0;
        for(int num: nums) {
            sum += (int) Math.ceil((double) num/divisor);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,5,9};
        int threshold = 6;
        System.out.println(SmallestDivisorGivenThreshold_1283.smallestDivisor(nums, threshold));
    }

}
