public class MaximumAvgSubarrayI {

    public static void main(String[] args) {
        System.out.println(findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;

        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double avg = sum / k;

        for (int i = k; i < n; i++) {
            sum = (sum - nums[i - k] + nums[i]);
            double newAvg = sum / k;
            if (newAvg > avg) {
                avg = newAvg;
            }
        }

        return avg;
    }

}
