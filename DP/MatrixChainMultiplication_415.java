import java.util.Arrays;
import java.util.List;

public class MatrixChainMultiplication_415 {

    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};

        System.out.println(matrixMultiplication(arr));
    }


    static int matrixMultiplication(int arr[]) {
        int n = arr.length;
        if (n < 3) {
            return 0;
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n-1; i++) {
             ans = Math.min(ans, Math.min(solve(arr, 1, i), solve(arr, i+1, n-1)));
        }
        return ans;
    }

    static int solve(int[] arr, int l, int r) {
        if (r == l) {
            return Integer.MAX_VALUE;
        }

        if(r-l == 1) {
            return arr[l-1]*arr[l]*arr[r];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = l+1; i < r-1; i++) {
            ans = Math.min(ans, Math.min(solve(arr, l, i), solve(arr, i+1, r-1)));
        }

        return ans;
    }

}
