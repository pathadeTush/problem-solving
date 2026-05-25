import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/subsets/
 */
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = (int) Math.pow(2, n);
        for(int i = 0; i < totalSubsets; i++) {
            List<Integer> item = new ArrayList<>();
            int k = 1;
            for(int j = 0; j < n; j++) {
                if((i & k) != 0) {
                    item.add(nums[j]);
                }
                k = k << 1;
            }
            ans.add(item);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }

}
