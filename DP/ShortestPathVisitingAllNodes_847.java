/**
 * https://leetcode.com/problems/shortest-path-visiting-all-nodes/description/
 */
public class ShortestPathVisitingAllNodes_847 {

    public static int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int ans = Integer.MAX_VALUE;

        int[] mask = new int[1];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            vis[i] = true;
            mask[0] = (1 << n)-1;
            mask[0] ^= 1 << i;
            int ans_i = solve(i, graph, vis, mask);
            ans = Math.min(ans, ans_i);
            vis[i] = false;
        }

        return ans;
    }

    private static int solve(int src, int[][] graph, boolean[] vis, int[] mask) {
        int ans = 0;
        int prevAns = 0;
        int prevMask = mask[0];
        for (int ng : graph[src]) {
            if (!vis[ng]) {
                vis[ng] = true;
                if(mask[0] != 0) {
                    mask[0] ^= 1 << ng;
                    ans += prevAns;
                    prevAns = 1 + solve(ng, graph, vis, mask);
                    ans += prevAns;
                } else {
                    mask[0] = prevMask;
                    mask[0] ^= 1 << ng;
                    prevAns = 1 + solve(ng, graph, vis, mask);
                    ans = Math.min(ans, prevAns);
                }
                vis[ng] = false;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1, 2, 3}, {0}, {0}, {0}};
        int[][] graph = new int[][]{{1},{0,2,4},{1,3,4},{2},{1,2}};
        System.out.println(ShortestPathVisitingAllNodes_847.shortestPathLength(graph));
    }

}
