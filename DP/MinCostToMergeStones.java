import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/minimum-cost-to-merge-stones/
 */
public class MinCostToMergeStones {

    static int[] prefix;

    public static int mergeStones(int[] stones, int k) {
        List<Integer> stoneList = Arrays.stream(stones).boxed().collect(Collectors.toList());
        int ans = solve(stoneList, k);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private static int solve(List<Integer> stones, int k) {
        int size = stones.size();
        if (size == 1) {
            return 0;
        }

        if (size < k) {
            return Integer.MAX_VALUE;
        }

        int cost = 0;
        int i = 0;
        int firstEle = stones.get(i);
        for (int j = 0; j < k; j++) {
            cost += stones.get(i);
            stones.remove(i);
        }
        stones.add(i, cost);

        int ans = Integer.MAX_VALUE;
        int possiblePairs = size - k + 1;
        while (possiblePairs > 0) {
            possiblePairs--;
            if (i != 0) {
                cost -= firstEle;
                cost += stones.get(i);
                stones.set(i - 1, firstEle);
                firstEle = stones.get(i);
                stones.set(i, cost);
            }

            List<Integer> prevStones = new ArrayList<>();
            prevStones.addAll(stones);
            int tempAns = solve(stones, k);
            if (tempAns != Integer.MAX_VALUE) {
                ans = Math.min(ans, tempAns + cost);
            }
            stones = prevStones;
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{3, 2, 4, 1};
//        int k = 3;
//        int[] nums = new int[]{3, 5, 1, 2, 6};
//        int k = 3;
        int[] nums = new int[]{4, 6, 4, 7, 5};
        int k = 2;
        System.out.println(MinCostToMergeStones.mergeStones(nums, k));
    }

}
