/**
 * https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 */
public class CapacityToShipPackagesWithinDDays_1011 {

    public static int shipWithinDays(int[] weights, int days) {
        int l = Integer.MAX_VALUE;
        int r = 0;
        for (int weight : weights) {
            r += weight;
            l = Math.min(l, weight);
        }

        int ans = -1;
        while (l <= r) {
            int mid = l - ((l - r) / 2);
            boolean possible = isPossible(weights, days, mid);
            if (possible) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    private static boolean isPossible(int[] weights, int days, int capacity) {
        int day = 1;
        int sum = 0;
        for (int weight : weights) {
            if(weight > capacity) {
                return false;
            }
            if (sum + weight <= capacity) {
                sum += weight;
            } else {
                sum = weight;
                day++;
            }
        }

        return day <= days;
    }

    public static void main(String[] args) {
//        int[] weights = new int[]{1,2,3,4,5,6,7,8,9,10};
//        int days = 5;
        int[] weights = new int[]{1,2,3,1,1};
        int days = 4;
        System.out.println(CapacityToShipPackagesWithinDDays_1011.shipWithinDays(weights, days));
    }

}
