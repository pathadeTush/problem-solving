import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    // Problem: https://leetcode.com/problems/non-overlapping-intervals/

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}};
        System.out.println(eraseOverlapIntervals(intervals));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));
//        Arrays.asList(intervals).forEach(ints -> System.out.println(ints[0] + ", " + ints[1]));
        int j = 1;
        int n = intervals.length;
        int count = 0;
        int y = intervals[0][1];

        while (j < n) {
            int x1 = intervals[j][0];
            int y1 = intervals[j][1];
            if (isOverlapping(y, x1)) {
                y = Math.min(y, y1);
                count++;
            } else {
                y = y1;
            }
            j++;
        }

        return count;
    }

    public static boolean isOverlapping(int y, int x1) {
        return y > x1;
    }

}
