import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class SumOfLargestPrimeNo {

    // Problem: https://leetcode.com/contest/biweekly-contest-157/problems/sum-of-largest-prime-substrings/

    public static void main(String[] args) {
        SumOfLargestPrimeNo sumOfLargestPrimeNo = new SumOfLargestPrimeNo();
        System.out.println(sumOfLargestPrimeNo.sumOfLargestPrimes("111"));
    }

    public long sumOfLargestPrimes(String s) {
        int n = s.length();
        long sum = 0;
        int count = 0;
        Map<Long, Integer> mp = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            StringBuilder num = new StringBuilder(s.substring(i));
            while (!num.isEmpty()) {
                long pno = Long.parseLong(num.toString());
                if (isPrime(pno)) {
                    mp.put(pno, 1);
                }
                num.deleteCharAt(num.length() - 1);
            }
        }

        return mp.keySet().stream().mapToLong(Long::longValue).limit(3).sum();
    }

    public boolean isPrime(long num) {
        if (num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }
        if(num %2 == 0) {
            return false;
        }

        for (long i = 3; i < Math.sqrt(num)+1;) {
            if (num % i == 0) {
                return false;
            }
            i+=2;
        }

        return true;
    }

}
