/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 */
public class MostStonesRemoved_947 {

    public static int removeStones(int[][] stones) {
        int n = 0;
        for(int[] stone: stones) {
            n = Math.max(n, Math.max(stone[0], stone[1]));
        }

        int[] stonesAtRow = new int[n+1];
        int[] stonesAtCol = new int[n+1];
        for(int[] stone: stones) {
            int row = stone[0];
            int col = stone[1];
            stonesAtRow[row]++;
            stonesAtCol[col]++;
        }

        boolean[][] vis = new boolean[n+1][n+1];

        return solve(stones, stonesAtRow, stonesAtCol, vis);
    }

    private static int solve(int[][] stones, int[] stonesAtRow, int[] stonesAtCol, boolean[][] vis) {
        int ans = 0;
        for(int[] stone: stones) {
            int row = stone[0];
            int col = stone[1];
            if((stonesAtRow[row] > 1 || stonesAtCol[col] > 1) && !vis[row][col]) {
                // remove
                int rowCount = stonesAtRow[row];
                int colCount = stonesAtCol[col];
                stonesAtRow[row] = Math.max(0, stonesAtRow[row]-1);
                stonesAtCol[col] = Math.max(0, stonesAtCol[col]-1);
                vis[row][col] = true;
                int remove = 1 + solve(stones, stonesAtRow, stonesAtCol, vis);
                vis[row][col] = false;

                // do not remove
                stonesAtRow[row] = rowCount;
                stonesAtCol[col] = colCount;
                ans = Math.max(ans, remove);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[][] stones = new int[][]{{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
//        System.out.println(MostStonesRemoved_947.removeStones(stones));
//        int[][] stones = new int[][]{{0,0},{0,2},{1,1},{2,0},{2,2}};
//        System.out.println(MostStonesRemoved_947.removeStones(stones));
        int[][] stones = new int[][]{{0,1},{1,2},{1,3},{3,3},{2,3},{0,2}};
        System.out.println(MostStonesRemoved_947.removeStones(stones));
    }

}
