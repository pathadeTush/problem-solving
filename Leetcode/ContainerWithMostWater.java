public class ContainerWithMostWater {

    // Problem: https://leetcode.com/problems/container-with-most-water/

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 1}));
    }

    public static int maxArea(int[] height) {
        int n = height.length;
        int l = 0, r = n - 1;
        int area = 0;
        while (l < r) {
            int curArea = Math.min(height[l], height[r]) * (r - l);
            area = Math.max(area, curArea);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return area;
    }

}
