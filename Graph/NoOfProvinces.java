import java.util.Scanner;

/**
 * https://leetcode.com/problems/number-of-provinces/description/
 */
public class NoOfProvinces {

    public static int findCircleNum(int[][] isConnected) {
        int ans = 0;
        int n = isConnected.length;
        boolean[] vis = new boolean[n];
        for(int src = 0; src < n; src++) {
            if(vis[src]) continue;
            ans++;
            dfs(src, vis, isConnected);
        }

        return ans;
    }

    public static void dfs(int src, boolean[] vis, int[][] isConnected) {
        vis[src] = true;
        int n = isConnected.length;
        for(int i = 0; i < n; i++) {
            if(vis[i] || isConnected[src][i] == 0) continue;
            dfs(i, vis, isConnected);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] isConnected = new int[n][n];
        for(int i = 0 ; i < n; i++) {
            for(int j = 0; j < n; j++) {
                isConnected[i][j] = sc.nextInt();
            }
        }
        sc.close();

        System.out.println(NoOfProvinces.findCircleNum(isConnected));
    }

}
