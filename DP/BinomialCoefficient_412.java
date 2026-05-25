public class BinomialCoefficient_412 {

    public static void main(String[] args) {
        System.out.println(nCr(4, 5));
    }

    public static long nCr(int n, int r) {
        if(n < r) {
            return 0;
        }
        long[][] dp = new long[n+1][r+1];

        for(int num = 0; num <= n; num++) {
            for(int r1 = 0; r1 <= r; r1++) {
                if(num < r1) {
                    continue;
                }
                if(num == 0 || num == 1 || r1 == 0 || num == r1) {
                    dp[num][r1] = 1;
                    continue;
                }

                dp[num][r1] = (num * dp[num-1][r1-1])/(r1);
            }
        }

        return dp[n][r];
    }

}
