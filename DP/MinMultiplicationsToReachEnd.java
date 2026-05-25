import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1
 */
public class MinMultiplicationsToReachEnd {

    private static class Pair {
        private int operations;
        private int prod;

        public Pair(int operations, int prod) {
            this.operations = operations;
            this.prod = prod;
        }

    }

    public static int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) {
            return 0;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, start));
        boolean[] vis = new boolean[99999];
        vis[start] = true;
        while (!queue.isEmpty()) {
            Pair node = queue.remove();
            for (Integer num : arr) {
                int newProd = (node.prod * num) % 100000;
                if (newProd == end) {
                    return node.operations+1;
                }
                if(!vis[newProd]) {
                    vis[newProd] = true;
                    queue.add(new Pair(node.operations+1, newProd));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

    }

}
