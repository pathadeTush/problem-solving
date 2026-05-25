import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://www.geeksforgeeks.org/problems/number-of-islands/1
 */

/**
 * NOT SOLVED
 */
public class NoOfIslands {

    private static class DisjointSet {
        private int len;
        private int[] size;
        private int[] parent;

        public DisjointSet(int len) {
            this.len = len;
            this.size = new int[len];
            this.parent = new int[len];
            Arrays.fill(size, 1);
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
        }

        public void unionBySize(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);

            if (parentU == parentV) {
                return;
            }

            if (size[parentU] >= size[parentV]) {
                size[parentU] += size[parentV];
                parent[parentV] = parentU;
            } else {
                size[parentV] += size[parentU];
                parent[parentU] = parentV;
            }
        }

        public int findParent(int u) {
            if (parent[u] == u) {
                return u;
            }

            return parent[u] = findParent(parent[u]);
        }

    }

    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        DisjointSet disjointSet = new DisjointSet(rows * cols);
        List<Integer> ans = new ArrayList<>();
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, 1, 0, -1};
        boolean[] vis = new boolean[rows * cols];
        for (int[] operator : operators) {
            int x = operator[0];
            int y = operator[1];
            int node = x * rows + cols;
            vis[node] = true;
            for (int i = 0; i < 4; i++) {
                int X = x + dx[i];
                int Y = y + dy[i];
                if (X >= 0 && X < rows && Y >= 0 && Y < cols) {
                    int ngNode = X * rows + cols;
                    if (vis[ngNode]) {
                        disjointSet.unionBySize(node, ngNode);
                    }
                }
            }
            ans.add(countUnique(disjointSet, vis));
        }

        return ans;
    }

    private static int countUnique(DisjointSet disjointSet, boolean[] vis) {
        Set<Integer> uniqueParents = new HashSet<>();
        for (int i = 0; i < disjointSet.len; i++) {
            uniqueParents.add(disjointSet.findParent(i));
        }

        return uniqueParents.size();
    }

//    public static List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
//        List<Integer> ans = new ArrayList<>();
//        int k = operators.length;
//        int count = 0;
//        for(int i = 0; i < k; i++) {
//            int[] operator = operators[i];
//            int u = operator[0];
//            int v = operator[1];
//
//            boolean inIsland = true;
//            for(int j = 0; j < i; j++) {
//                int[] prevOperator = operators[j];
//                int x = prevOperator[0];
//                int y = prevOperator[1];
//                int[] dx = new int[]{-1, 0, 1, 0};
//                int[] dy = new int[]{0, 1, 0, -1};
//                for(int p = 0; p < 4; p++) {
//                    int X = u + dx[p];
//                    int Y = v + dy[p];
//                    if(X >= 0 && X < rows && Y >= 0 && Y < cols && x == X && y == Y) {
//                        inIsland = false;
//                        break;
//                    }
//                }
//            }
//            if(inIsland) {
//                count++;
//            }
//            ans.add(count);
//        }
//
//        return ans;
//    }

    public static void main(String[] args) {
        int rows = 4, cols = 5;
        int[][] operators = new int[][]{{1, 1}, {0, 1}, {3, 3}, {3, 4}};
        System.out.println(NoOfIslands.numOfIslands(rows, cols, operators));
//        int rows = 5, cols = 8;
//        int[][] operators = new int[][]{{0,3},{4,3},{3,1},{3,5}};
//        System.out.println(NoOfIslands.numOfIslands(rows, cols, operators));
    }

}
