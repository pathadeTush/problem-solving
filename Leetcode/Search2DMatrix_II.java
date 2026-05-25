public class Search2DMatrix_II {

    // Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0, col = n-1;
        while (row < m && col >= 0) {
            int ele = matrix[row][col];
            if(ele == target) {
                return true;
            }

            if(target > ele) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }

}
