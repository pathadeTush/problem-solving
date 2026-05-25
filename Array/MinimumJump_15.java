import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MinimumJump_15 {

    /*
      Using dp
     */
    public static int minJumps(int[] arr, int n, int idx, int[] dp) {
        if(idx >= n-1) {
            return 0;
        }
        if(arr[idx] == 0) {
            return -1;
        }
        if(dp[idx] != -2) {
            return dp[idx];
        }

        int minJump = Integer.MAX_VALUE;
        for(int i = 1; i <= arr[idx]; i++) {
            int jumpI = minJumps(arr, n, idx+i, dp);
            if(jumpI >= 0 && jumpI != Integer.MAX_VALUE) {
                minJump = Math.min(minJump, 1 + jumpI);
            }
        }

        return dp[idx] = minJump == Integer.MAX_VALUE? -1: minJump;
    }

    public static int minJumps(int[] arr, int n) {
        int dp[] = new int[n];
        Arrays.fill(dp, -2);
        return minJumps(arr, n, 0, dp);
    }

    public static int minJump(int[] arr, int n) {
        if(arr[0] == 0) {
            return -1;
        }

        int maximumPosn = arr[0];
        int pointsLeft = arr[0];
        int jump = 1;

        for(int i = 1; i < n; i++) {
            if(i >= n-1) {
                return jump;
            }

            maximumPosn = Math.max(maximumPosn, arr[i]+i);
            pointsLeft--;
            if(pointsLeft == 0) {
                pointsLeft = maximumPosn - i;
                jump++;
            }
        }

        return jump;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[] arrStr = ((String)br.readLine()).split("\\s+");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        System.out.println(minJump(arr, size));
    }

}
