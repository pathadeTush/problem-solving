package top_interview_150;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GameOfLife_289 {

    public static void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] newBoard = new int[m][n];

        int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 0) {
                    int totalLiveNeighbors = 0;
                    for(int k = 0; k < 8; k++) {
                        int x = i + di[k];
                        int y = j + dj[k];
                        if(isValid(x, y, m, n) && board[x][y] == 1) {
                            totalLiveNeighbors++;
                        }
                        if(totalLiveNeighbors > 3) break;
                    }
                    if(totalLiveNeighbors == 3) {
                        newBoard[i][j] = 1;
                    }
                } else {
                    int totalLiveNeighbors = 0;
                    for(int k = 0; k < 8; k++) {
                        int x = i + di[k];
                        int y = j + dj[k];
                        if(isValid(x, y, m, n) && board[x][y] == 1) {
                            totalLiveNeighbors++;
                        }
                        if(totalLiveNeighbors > 3) break;
                    }
                    if(totalLiveNeighbors == 2 || totalLiveNeighbors == 3) {
                        newBoard[i][j] = 1;
                    }
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = newBoard[i][j];
            }
        }
    }

    private static boolean isValid(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

}
