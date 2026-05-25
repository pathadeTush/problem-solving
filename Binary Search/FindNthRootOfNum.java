/**
 * https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1
 */
public class FindNthRootOfNum {

    public static int nthRoot(int m, int n) {
        int l = 0;
        int r = n;
        while (l <= r) {
            int mid = (l+r) / 2;
            int midPow = (int) Math.pow(mid, m);
            if(midPow == n) {
                return mid;
            } else if(midPow > n) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(FindNthRootOfNum.nthRoot(6, 0));
    }

}
