import java.util.PriorityQueue;

/**
 * https://www.geeksforgeeks.org/problems/minimize-max-distance-to-gas-station/1
 */
public class MinimiseMaxDistanceToGasStations {

    public static double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        double[] diffArr = new double[n-1];
        double l = 0;
        double r = 0;
        for(int i = 1; i < n; i++) {
            diffArr[i-1] = stations[i] - stations[i-1];
            r = Math.max(r, diffArr[i-1]);
        }

        while (r-l > 1/1e6) {
            double mid = (l+r)/2.0;
            boolean possible = isPossible(diffArr, K, mid);
            if(possible) {
                r = mid;
            } else {
                l = mid;
            }
        }

        return Math.floor(r*1e6)/1e6;
    }

    private static boolean isPossible(double[] diffArr, int k, double mid) {
        int count = 0;
        for(double diff: diffArr) {
            if(diff <= mid) {
                continue;
            }
            count += ((int) Math.ceil(diff /mid))-1;
            if(count > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
//        int[] stations = new int[]{1, 2, 3, 4, 5};
//        int k = 2;
//        int[] stations = new int[]{3, 6, 12, 19, 33};
//        int k = 3;
        int[] stations = new int[]{13};
        int k = 1;
        System.out.println(MinimiseMaxDistanceToGasStations.minMaxDist(stations, k));
    }

}
