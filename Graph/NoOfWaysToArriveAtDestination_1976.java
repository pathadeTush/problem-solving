import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
 */
public class NoOfWaysToArriveAtDestination_1976 {

    private static final int MOD = (int) (1e9 + 7);

//    public static int countPaths(int n, int[][] roads) {
//        List<int[]>[] adj = new List[n];
//        for (int i = 0; i < n; i++) {
//            adj[i] = new ArrayList<>();
//        }
//        for (int i = 0; i < roads.length; i++) {
//            int src = roads[i][0];
//            int dst = roads[i][1];
//            int time = roads[i][2];
//            adj[src].add(new int[]{dst, time});
//            adj[dst].add(new int[]{src, time});
//        }
//
//        Map<Long, Integer> timeCountMap = new HashMap<>();
//        boolean[] vis = new boolean[n];
//        vis[0] = true;
//        timeCountMap.put(0l, 0);
//        long minTime = solve(0, adj, vis, n, timeCountMap, 0l);
//        return timeCountMap.get(minTime);
//    }
//
//    private static long solve(int src, List<int[]>[] adj, boolean[] vis, int n, Map<Long, Integer> timeCountMap, Long time) {
//        if (src == n - 1) {
//            timeCountMap.put(time, (timeCountMap.getOrDefault(time, 0) + 1) % MOD);
//            return time;
//        }
//
//        long minTime = Long.MAX_VALUE;
//        for (int[] pair : adj[src]) {
//            int ng = pair[0];
//            int newTime = pair[1];
//            if (!vis[ng]) {
//                vis[ng] = true;
//                minTime = Math.min(minTime, solve(ng, adj, vis, n, timeCountMap, time + newTime));
//                vis[ng] = false;
//            }
//        }
//
//        return minTime;
//    }

    private static class Pair {
        private long time;
        private int node;

        public Pair(long time, int node) {
            this.time = time;
            this.node = node;
        }
    }

    public static int countPaths(int n, int[][] roads) {
        List<int[]>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            int src = roads[i][0];
            int dst = roads[i][1];
            int time = roads[i][2];
            adj[src].add(new int[]{dst, time});
            adj[dst].add(new int[]{src, time});
        }

        long[] timeArr = new long[n];
        Arrays.fill(timeArr, Long.MAX_VALUE);
        int[] nodeWays = new int[n];
        timeArr[0] = 0l;
        nodeWays[0] = 1;

        Queue<Pair> queue = new PriorityQueue<>(Comparator.comparing(pair -> pair.time));
        queue.add(new Pair(0l, 0));
        while (!queue.isEmpty()) {
            Pair top = queue.remove();
            int node = top.node;
            long time = top.time;
//            if (node == n - 1) {
//                return nodeWays[node];
//            }
            for (int[] pair : adj[node]) {
                int newNode = pair[0];
                int newTime = pair[1];
                if (timeArr[newNode] > time + newTime) {
                    timeArr[newNode] = time + newTime;
                    nodeWays[newNode] = nodeWays[node];
                    queue.add(new Pair(time + newTime, newNode));
                } else if (timeArr[newNode] == time + newTime) {
                    timeArr[newNode] = time + newTime;
                    nodeWays[newNode] = (nodeWays[newNode] + nodeWays[node]) % MOD;
                    continue;
                }
            }
        }

        return nodeWays[n - 1];
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] roads = new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}};
//        int n = 2;
//        int[][] roads = new int[][]{{1, 0, 10}};
        System.out.println(NoOfWaysToArriveAtDestination_1976.countPaths(n, roads));
    }

}
