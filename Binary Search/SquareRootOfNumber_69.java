/**
 * https://leetcode.com/problems/sqrtx/
 */
public class SquareRootOfNumber_69 {

    public static int mySqrt(int x) {
        long l = 1;
        long r = x;

        long ans = (l+r) >> 1;
        while (l <= r) {
            long mid = (l+r) >> 1;
            long midSqr = mid*mid;
            if(midSqr == x) {
                return (int) mid;
            } else if(midSqr > x) {
                r = mid-1;
            } else {
                ans = mid;
                l = mid+1;
            }
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        System.out.println(SquareRootOfNumber_69.mySqrt(2147395599));
    }

}
