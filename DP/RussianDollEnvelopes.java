import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/russian-doll-envelopes/
 */
public class RussianDollEnvelopes {

    public static int maxEnvelopes(int[][] envelopes) {
        int[][] sortedEnvelopes = Arrays.stream(envelopes).sorted(RussianDollEnvelopes::compare).toArray(int[][]::new);
//        for(int i = 0; i < sortedEnvelopes.length; i++) {
//            System.out.print(" ["+sortedEnvelopes[i][0] +", "+sortedEnvelopes[i][1]+"],");
//        }
        Map<int[][], Integer> dp = new HashMap<>();

        return solve(sortedEnvelopes, 0, envelopes.length, new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}, dp);
    }

    public static int solve(int[][] sortedEnvelopes, int idx, int n, int[] prev, Map<int[][], Integer> dp) {
        if(idx >= n) {
            return 0;
        }

        int[][] key = new int[][]{{idx}, prev};
        if(dp.containsKey(key)) {
            return dp.get(key);
        }

        int ans = 0;
        if(prev[0] > sortedEnvelopes[idx][0] && prev[1] > sortedEnvelopes[idx][1]) {
            int ans1 = 1 + solve(sortedEnvelopes, idx+1, n, sortedEnvelopes[idx], dp);
            int ans2 = solve(sortedEnvelopes, idx+1, n, prev, dp);
            ans = Math.max(ans1, ans2);
        } else {
            ans = solve(sortedEnvelopes, idx+1, n, prev, dp);
        }
        dp.put(key, ans);
        return ans;
    }

    private static int compare(int[] env1, int[] env2) {
        if(env1[0] > env2[0]) {
            return -1;
        } else if (env1[0] < env2[0]) {
            return 1;
        } else {
            return env1[1] >= env2[1] ? -1: 1;
        }
    }

    public static void main(String[] args) {
        int[][] envelopes = new int[][] {{5,4},{6,4},{6,7},{2,3}};
//        int[][] envelopes = new int[][] {{1,1},{1,1},{1,1},{1,1}};
        System.out.println(RussianDollEnvelopes.maxEnvelopes(envelopes));
    }

}
