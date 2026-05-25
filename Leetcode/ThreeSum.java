import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class ThreeSum {

    // Problem: https://leetcode.com/problems/3sum/

    public static void main(String[] args) {
//        System.out.println(threeSum(new int[]{-2, 0, 1, 1, 2}));
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(22, 0);
        mp.put(01, 0);
        mp.put(3, 0);
        System.out.println(mp);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int l = i + 1;
            int r = n - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    r -= 1;
                }
                if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return new ArrayList<>(ans);
    }

}
