package top_interview_150;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ValidSudoku_36 {

    public static boolean isValidSudoku(char[][] board) {
        Set<Character>[] rowSet = new Set[9];
        Set<Character>[] colSet = new Set[9];
        for(int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
        }
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') {
                    continue;
                }
                if (rowSet[row].contains(board[row][col])) {
                    System.out.println(Arrays.stream(rowSet).toList());
                    System.out.println("row: " + row + " ele: " + board[row][col] + "  "+rowSet[row]);
                    return false;
                }
                rowSet[row].add(board[row][col]);
                if (colSet[col].contains(board[row][col])) {
                    System.out.println("col: " + row + " ele: " + board[row][col]);
                    return false;
                }
                colSet[col].add(board[row][col]);
            }
        }

        for (int startRow = 0; startRow < 3; startRow++) {
            for (int startCol = 0; startCol < 3; startCol++) {
                Set<Character> subBoxSet = new HashSet<>();
                for (int row = 3 * startRow; row < 3 * startRow + 3; row++) {
                    for (int col = 3 * startCol; col < 3 * startCol + 3; col++) {
                        if (board[row][col] == '.') {
                            continue;
                        }
                        if (subBoxSet.contains(board[row][col])) {
                            System.out.println("row: " + row + "  col: " + col + " ele: " + board[row][col]);
                            return false;
                        }
                        subBoxSet.add(board[row][col]);
                    }
                }
            }
        }

        return true;
    }

}
