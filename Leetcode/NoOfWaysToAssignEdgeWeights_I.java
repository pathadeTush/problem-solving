import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class NoOfWaysToAssignEdgeWeights_I {

    // Problem: https://leetcode.com/contest/biweekly-contest-157/problems/number-of-ways-to-assign-edge-weights-i/

    public static void main(String[] args) {

    }

    public static int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            if (tree[x] == null) {
                tree[x] = new ArrayList<>();
            }
            tree[x].add(y);
        }

        return 0;

    }

}
