import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode.com/problems/minimum-number-of-work-sessions-to-finish-the-tasks/
 */
public class MinNoOfWorkSessionsToFinishTask_1986 {

//    private static class DPKey {
//        private int pendingTime;
//        private boolean[] vis;
//
//        public DPKey(int pendingTime, boolean[] vis) {
//            this.pendingTime = pendingTime;
//            this.vis = Arrays.copyOf(vis, vis.length);
//        }
//
//        @Override
//        public int hashCode() {
//            int result = Integer.hashCode(pendingTime);
//            result = 31 * result + Arrays.hashCode(vis);
//            return result;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            DPKey that = (DPKey) o;
//            return Objects.equals(pendingTime, that.pendingTime)
//                    && Arrays.equals(vis, that.vis);
//        }
//
//    }

//    public static int minSessions(int[] tasks, int sessionTime) {
//        int n = tasks.length;
//        boolean[] vis = new boolean[n];
//
//        Map<DPKey, Integer> dp = new HashMap<>();
//        return solve(tasks, vis, sessionTime, sessionTime, dp);
//    }
//
//    private static int solve(int[] tasks, boolean[] vis, int sessionTime, int pendingTime, Map<DPKey, Integer> dp) {
//        DPKey dpKey = new DPKey(pendingTime, vis);
//        if(dp.containsKey(dpKey)) {
//            return dp.get(dpKey);
//        }
//
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < tasks.length; i++) {
//            if (!vis[i]) {
//                int tempAns = Integer.MAX_VALUE;
//                vis[i] = true;
//                if (tasks[i] > pendingTime) {
//                    tempAns = 1 + solve(tasks, vis, sessionTime, sessionTime - tasks[i], dp);
//                } else {
//                    tempAns = solve(tasks, vis, sessionTime, pendingTime - tasks[i], dp);
//                }
//                vis[i] = false;
//                ans = Math.min(ans, tempAns);
//            }
//        }
//
//        ans = ans == Integer.MAX_VALUE ? 1 : ans;
//        dp.put(dpKey, ans);
//        return ans;
//    }

    public static int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        boolean[] vis = new boolean[n];

        int[][] dp = new int[1<<14][sessionTime+1];
        return solve(tasks, 0, sessionTime, sessionTime, dp);
    }

    private static int solve(int[] tasks, int mask, int sessionTime, int pendingTime, int[][] dp) {
        if(dp[mask][pendingTime] != 0) {
            return dp[mask][pendingTime];
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < tasks.length; i++) {
            if ((mask & 1 << i) == 0) {
                int tempAns = Integer.MAX_VALUE;
                if (tasks[i] > pendingTime) {
                    tempAns = 1 + solve(tasks, mask | 1 << i, sessionTime, sessionTime - tasks[i], dp);
                } else {
                    tempAns = solve(tasks, mask | 1 << i, sessionTime, pendingTime - tasks[i], dp);
                }
                ans = Math.min(ans, tempAns);
            }
        }

        ans = ans == Integer.MAX_VALUE ? 1 : ans;
        dp[mask][pendingTime] = ans;
        return ans;
    }

    public static void main(String[] args) {
//        int[] tasks = new int[]{1, 2, 3};
//        int sessionTime = 3;

//        int[] tasks = new int[]{3,1,3,1,1};
//        int sessionTime = 8;

        int[] tasks = new int[]{1, 2, 3, 4, 5};
        int sessionTime = 15;
        System.out.println(MinNoOfWorkSessionsToFinishTask_1986.minSessions(tasks, sessionTime));
    }

}
