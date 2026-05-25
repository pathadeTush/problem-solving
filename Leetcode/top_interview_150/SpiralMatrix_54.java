package top_interview_150;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SpiralMatrix_54 {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int count = 0; // total cell visited
        int startRow = 0;
        int startCol = 0;

        List<Integer> ans = new ArrayList<>();
        while (count < m*n) {
            // right
            for(int col = startCol; col < n-startCol; col++) {
                ans.add(matrix[startRow][col]);
                count++;
            }
            if(count >= m*n) break;

            // down
            for(int row = startRow+1; row < m-startRow; row++) {
                ans.add(matrix[row][n-1-startCol]);
                count++;
            }
            if(count >= m*n) break;

            // left
            for(int col = n-2-startCol; col >= startCol; col--) {
                ans.add(matrix[m-1-startRow][col]);
                count++;
            }
            if(count >= m*n) break;

            // up
            for(int row = m-2-startRow; row > startRow; row--) {
                ans.add(matrix[row][startCol]);
                count++;
            }

            startRow++;
            startCol++;
        }

        return ans;
    }

}
