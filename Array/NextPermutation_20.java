public class NextPermutation_20 {

    public void nextPermutation(int[] nums) {
        boolean isDescending = false;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                isDescending = true;
                break;
            }
        }

        if(isDescending) {
            for(int i = 0; i < nums.length >> 1; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length-1 - i];
                nums[nums.length-1 - i] = temp;
            }

            return;
        }

        boolean isGreaterThanPreviousFound = false;
        while (!isGreaterThanPreviousFound) {
            for(int i = nums.length-1; i > 0; i--) {
                if(nums[i] > nums[i-1]) {
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                    isGreaterThanPreviousFound = true;
                    break;
                } else {
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                }
            }
        }
    }

}
