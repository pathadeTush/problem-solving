public class CountWordIn2DArr_78 {

    public static boolean isValidPos(int x, int y, int r, int c) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }

    public static int findOccurrence(char[][] mat, int x, int y, int r, int c, String target, int len) {
        if (len == target.length()) {
            return 1;
        }

        int[] dirX = {-1, 0, 1, 0};
        int[] dirY = {0, 1, 0, -1};
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int X = x + dirX[i];
            int Y = y + dirY[i];
            if (isValidPos(X, Y, r, c) && mat[X][Y] != '$' && mat[X][Y] == target.charAt(len)) {
                char originalChar = mat[X][Y];
                mat[X][Y] = '$';
                ans += findOccurrence(mat, X, Y, r, c, target, len + 1);
                mat[X][Y] = originalChar;
            }
        }

        return ans;
    }

    public static int findOccurrence(char[][] mat, String target) {
        int r = mat.length;
        int c = mat[0].length;
        int ans = 0;
        for (int x = 0; x < r; x++) {
            for (int y = 0; y < c; y++) {
                if (mat[x][y] == target.charAt(0)) {
                    char originalChar = mat[x][y];
                    mat[x][y] = '$';
                    ans += findOccurrence(mat, x, y, r, c, target, 1);
                    mat[x][y] = originalChar;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
//        char[][] mat = {
//                {'S', 'N', 'B', 'S', 'N'},
//                {'B', 'A', 'K', 'E', 'A'},
//                {'B', 'K', 'B', 'B', 'K'},
//                {'S', 'E', 'B', 'S', 'E'}};
//        String target = "SNAKES";
        char[][] mat = {
                {'c', 'a', 't'},
                {'a', 't', 'c'},
                {'c', 't', 'a'}};
        String target = "tat";
        System.out.println(findOccurrence(mat, target));
    }

}
