import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/find-eventual-safe-states/description/
 */
public class EventualSafeStates_802 {

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> ans = new HashSet<>();
        int n = graph.length;
        boolean[] vis = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                checkSafeNode(i, graph, vis, ans);
            }
        }

        return ans.stream().sorted().collect(Collectors.toList());
    }

    private static boolean checkSafeNode(int src, int[][] graph, boolean[] vis, Set<Integer> ans) {
        vis[src] = true;

        boolean isSafeNode = true;
        for (int ng : graph[src]) {
            if (!vis[ng]) {
                isSafeNode = isSafeNode && checkSafeNode(ng, graph, vis, ans);
            } else {
                isSafeNode = isSafeNode && (ans.contains(ng));
            }
        }

        if (isSafeNode) {
            ans.add(src);
        }
        return isSafeNode;
    }

    public static void main(String[] args) {
//        int[][] graph = new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        int[][] graph = new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}};
        System.out.println(EventualSafeStates_802.eventualSafeNodes(graph));
    }

}
