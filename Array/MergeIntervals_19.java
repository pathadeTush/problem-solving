
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals_19 {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int len = intervals.length;
        ArrayList<ArrayList<Integer>> mergedIntervals = new ArrayList<>();
        int i = 0;
        while(i < len) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while(i+1 < len && intervals[i+1][0] <= intervals[i][1]) {
                end = Math.max(end, intervals[i+1][1]);
                i++;
            }
            mergedIntervals.add(new ArrayList<>(List.of(start, end)));
            i++;
        }

        int[][] ans = new int[mergedIntervals.size()][2];
        int j = 0;
        for(ArrayList<Integer> list: mergedIntervals) {
            ans[j][0] = list.get(0);
            ans[j][1] = list.get(1);
            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] mergedIntervals = merge(intervals);

        System.out.print("[");
        for (int[] mergedInterval : mergedIntervals) {
            System.out.print("[" + mergedInterval[0] + ", " + mergedInterval[1] + "]");
        }
        System.out.println();
    }

}
