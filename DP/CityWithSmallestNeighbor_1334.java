import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
 */
public class CityWithSmallestNeighbor_1334 {

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int dist = edges[i][2];
            List<int[]> ulist = adj.get(u);
            ulist.add(new int[]{v, dist});
            List<int[]> vlist = adj.get(v);
            vlist.add(new int[]{u, dist});
        }

        int ans = -1;
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            int count = dijkstra(i, adj, n, distanceThreshold);
            if(minCount >= count) {
                minCount = count;
                ans = Math.max(ans, i);
            }
        }

        return ans;
    }

    /**
     *
     * @param src
     * @param adj
     * @param n
     * @param threshold
     * @return count of nodes which are at most threshold dist away from src
     */
    private static int dijkstra(int src, List<List<int[]>> adj, int n, int threshold) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a -> a[0]));
        pq.add(new int[]{0, src});

        while (!pq.isEmpty()) {
            int dist = pq.peek()[0];
            int node = pq.peek()[1];
            pq.remove();

            for(int[] neighbor: adj.get(node)) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];

                if(dis[neighborNode] > dist + edgeWeight) {
                    dis[neighborNode] = dist+edgeWeight;
                    pq.add(new int[]{dist+edgeWeight, neighborNode});
                }
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++) {
            if(i != src && dis[i] <= threshold) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
//        int n = 4;
//        int[][] edges = new int[][] {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
//        int distThreshold = 4;

        int n = 5;
        int[][] edges = new int[][] {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distThreshold = 4;

        System.out.println(CityWithSmallestNeighbor_1334.findTheCity(n, edges, distThreshold));
    }

}
