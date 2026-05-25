import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestSum {

    // problem: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/

    public static void main(String[] args) {
        System.out.println(kSmallestPairs(new int[]{1, 2, 4, 5, 6}, new int[]{3, 5, 7, 9}, 5));
    }

    public static class Pair {
        public int sum;
        public int x;
        public int y;

        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    public static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.sum < o2.sum) {
                return -1;
            } else if (o1.sum == o2.sum) {
                return 0;
            }
            return 1;
        }

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<List<Integer>> vis = new HashSet<>();

        int m = nums1.length;
        int n = nums2.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.sum));
        pq.add(new Pair(0, 0, nums1[0] + nums2[0]));

        while (!pq.isEmpty() && k-- > 0) {
            Pair pair = pq.remove();
            int i = pair.x;
            int j = pair.y;
            ans.add(List.of(nums1[i], nums2[j]));
            if (i < m - 1 && !vis.contains(List.of(i + 1, j))) {
                pq.add(new Pair(i + 1, j, nums1[i + 1] + nums2[j]));
                vis.add(List.of(i + 1, j));
            }
            if (j < n - 1 && !vis.contains(List.of(i, j + 1))) {
                pq.add(new Pair(i, j + 1, nums1[i] + nums2[j + 1]));
                vis.add(List.of(i, j + 1));
            }
        }


        return ans;
    }

}
