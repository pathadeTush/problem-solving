import java.util.Arrays;

public class EditDistance_69 {

    public static int solve(String str1, String str2, int i, int j, int n1, int n2, int[][] dp) {
        if(i >= n1 || j >= n2) {
            return Math.max(n1-i, n2-j);
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int dist;
        if(str1.charAt(i) == str2.charAt(j)) {
            dist = solve(str1, str2, i+1, j+1, n1, n2, dp);
        } else {
            // add
            int addDist = 1 + solve(str1, str2, i, j+1, n1, n2, dp);
            // remove
            int removeDist = 1 + solve(str1, str2, i+1, j, n1, n2, dp);
            // replace
            int replaceDist = 1 + solve(str1, str2, i+1, j+1, n1, n2, dp);
            dist = Math.min(Math.min(addDist, removeDist), replaceDist);
        }

        return dp[i][j] = dist;
    }

    public static int editDistance(String str1, String str2) {
        int n1 = str1.length();
        int n2 = str2.length();
        int[][] dp = new int[n1][n2];
        for(int i = 0; i < n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(str1, str2, 0, 0, n1, n2, dp);
    }

    public static void main(String[] args) {
        String str1 = "geekt";
        String str2 = "gesekr";

        System.out.println(editDistance(str1, str2));
    }

}
