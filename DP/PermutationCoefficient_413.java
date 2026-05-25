public class PermutationCoefficient_413 {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        System.out.println(permutationCoeff(14, 12));
    }

    public static int permutationCoeff(int n, int k) {
        int ans = 1;
        for (int i = n; i > n - k; i--) {
            ans = (int)(((long) ans * i) % MOD);
        }

        return ans;
    }

}
