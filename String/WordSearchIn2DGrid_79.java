import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSearchIn2DGrid_79 {

    public enum DIR {
        UP,
        RIGHT,
        DOWN,
        LEFT,
        LEFT_UP,
        UP_RIGHT,
        RIGHT_DOWN,
        DOWN_LEFT
    }

    public static boolean isValidPos(int x, int y, int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }

    public static int getMaxLen(int x, int y, int m, int n, DIR dir) {
        switch (dir) {
            case UP:
                return x + 1;
            case RIGHT:
                return n - y;
            case DOWN:
                return m - x;
            case LEFT:
                return y + 1;
            case LEFT_UP:
                return Math.min(x + 1, y + 1);
            case UP_RIGHT:
                return Math.min(x + 1, n - y);
            case RIGHT_DOWN:
                return Math.min(n - y, m - x);
            case DOWN_LEFT:
                return Math.min(m - x, y + 1);
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int getNextX(int x, DIR dir) {
        switch (dir) {
            case UP:
            case LEFT_UP:
            case UP_RIGHT:
                return x - 1;
            case RIGHT:
            case LEFT:
                return x;
            case DOWN:
            case RIGHT_DOWN:
            case DOWN_LEFT:
                return x + 1;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static int getNextY(int y, DIR dir) {
        switch (dir) {
            case UP:
            case DOWN:
                return y;
            case RIGHT:
            case RIGHT_DOWN:
            case UP_RIGHT:
                return y + 1;
            case LEFT_UP:
            case LEFT:
            case DOWN_LEFT:
                return y - 1;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static boolean isPossibleForDir(int x, int y, int m, int n, int len, int requiredLen, DIR dir) {
        return len + getMaxLen(x, y, m, n, dir) >= requiredLen;
    }

    public static boolean solve(char[][] grid, int x, int y, int m, int n, String word, DIR prevDir, int len) {
        if (len == word.length()) {
            return true;
        }

        if (isValidPos(x, y, m, n) && isPossibleForDir(x, y, m, n, len, word.length(), prevDir) && grid[x][y] == word.charAt(len)) {
            return solve(grid, getNextX(x, prevDir), getNextY(y, prevDir), m, n, word, prevDir, len + 1);
        }

        return false;
    }

    public static int[][] searchWord(char[][] grid, String word) {
        List<List<Integer>> ans = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(grid[x][y] == word.charAt(0)) {
                    for(DIR dir: DIR.values()) {
                        if(solve(grid, x, y, m, n, word, dir, 0)) {
                            ans.add(List.of(x, y));
                            break;
                        }
                    }
                }
            }
        }

        int[][] ans1 = new int[ans.size()][2];
        for(int i = 0; i < ans.size(); i++) {
            ans1[i][0] = ans.get(i).get(0);
            ans1[i][1] = ans.get(i).get(1);
        }

        return ans1;
    }

    public static void main(String[] args) {
        char[][] grid = {{'c','a','d','b','c','c','c','a','b','e','c'},
                {'d','e','a','d','d','a','d','e','a','e','a'},
                {'c','e','e','e','a','d','d','a','d','a','a'},
                {'d','d','e','e','e','c','b','c','b','e','b'},
                {'c','a','e','d','a','d','d','c','b','c','c'},
                {'d','d','d','c','e','d','d','e','a','d','b'},
                {'b','e','c','b','b','d','e','b','e','a','a'},
                {'e','d','c','e','e','d','d','d','e','b','b'},
                {'a','c','c','e','e','a','a','b','a','a','b'},
                {'c','b','b','c','b','a','c','e','c','a','b'}};
        String word = "dee";
        System.out.println(Arrays.deepToString(searchWord(grid, word)));
    }

}
