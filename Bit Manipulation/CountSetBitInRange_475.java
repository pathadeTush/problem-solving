
import java.util.*;

/**
 * 475CountSetBitInRange
 */
public class CountSetBitInRange_475 {

    /*
        Find gratest number which is power of 2 and not greater than n

        0000
        0001
        0010 -> 2, totalSetBits = 2
        0011
        0100 -> 4, totalSetBits = 5
        0101
        0110
        0111
        1000 -> 8, totalSetBits = 13
        1001
        1010
        1011
        1100
        1101
        1110
        1111
       10000 -> 16, totalSetBits = 33

       totalSetBits upto number(2^x) = 1 + (totalBit-1) * (2^x/2)
       totalSetBits(n) = 1 + (totalBit-1) * (2^x/2)+ n + totalSetBit(n - 2^x)
         */

    /***
     *
     * @param n
     * @return total set bits from 1 to n
     */
    public static int countSetBits(int n, Map<Integer, Integer> dp) {
         if(n < 1) {
            return 0;
         } else if (n < 2) {
            return 1;
         }
         if(dp.containsKey(n)) {
            return dp.get(n);
         }

         int totalBitInPowerOf2 = log2(n).intValue();
         int powerOf2Num = 1 << totalBitInPowerOf2;

         int ans = 1 + totalBitInPowerOf2 * (powerOf2Num/2) + n - powerOf2Num + countSetBits(n - powerOf2Num, dp);
         dp.put(n, ans);

        return ans;
    }

    public static Double log2(int n) {
        return Math.log(n) / Math.log(2);
    }

    public static void main(String[] args) {
        int n;
        try (Scanner scanner = new Scanner(System.in)) {
            n = scanner.nextInt();
        }

        Map<Integer, Integer> dp = new HashMap<>();

        System.out.println(countSetBits(n, dp));
    }

}