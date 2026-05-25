package top_interview_150;

import java.util.Arrays;
import java.util.Comparator;

/**
 * https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinArrowsToBurstBalloons_452 {

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int ans = 1;
        long lastPoint = Long.MIN_VALUE;
        for(int[] point: points) {
            if (lastPoint < point[0]) {
                ans++;
                lastPoint = point[1];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,16},{2,8},{1,6},{7,12}};
        System.out.println(findMinArrowShots(points));
    }

}
