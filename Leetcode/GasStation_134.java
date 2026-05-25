/**
 * https://leetcode.com/problems/gas-station/?envType=study-plan-v2&envId=top-interview-150
 */
public class GasStation_134 {

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        for (int startIdx = 0; startIdx < n; startIdx++) {
            int j = startIdx;
            int totalGas = gas[j];
            boolean possible = true;
            do {
                totalGas -= cost[j];
                if(totalGas < 0) {
                    possible = false;
                    break;
                }
                j = (j + 1) % n;
                totalGas += gas[j];
            } while (j != startIdx);
            if(possible) {
                return startIdx;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
//        int[] gas = new int[]{1,2,3,4,5};
//        int[] cost = new int[]{3,4,5,1,2};
//        System.out.println(GasStation_134.canCompleteCircuit(gas, cost));
        int[] gas = new int[]{2,3,4};
        int[] cost = new int[]{3,4,3};
        System.out.println(GasStation_134.canCompleteCircuit(gas, cost));
    }

}
