/**
 * https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1
 */
public class PaintersPartitionII {

    public static int minTime(int[] arr, int k) {
        int l = Integer.MIN_VALUE;
        int r = 0;
        for(int len: arr){
            l = Math.max(l, len);
            r += len;
        }

        int ans = -1;

        while (l <= r) {
            int mid = (l+r) >> 1;
            boolean possible = isPossible(arr, k, mid);
            if(possible) {
                r = mid-1;
                ans = mid;
            } else {
                l = mid+1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] arr, int k, int mid) {
        int count = 1;
        int sum = 0;
        for(int len: arr) {
            sum += len;
            if(sum > mid) {
                count++;
                sum = len;
            }
        }

        return count <= k;
    }

    public static void main(String[] args) {
//        int[] arr = new int[]{5, 10, 30, 20, 15};
//        int k = 3;
        int[] arr = new int[]{10, 5, 20, 25, 17, 23, 2, 9, 4, 13};
        int k = 7;
        System.out.println(PaintersPartitionII.minTime(arr, k));
    }

}
