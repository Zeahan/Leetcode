package NO152;

public class Solution {
    int max;
    int iMax;
    int iMin;

    public int maxProduct(int[] nums) {
        if (nums.length == 1) { return nums[0]; }
        max = nums[0];
        iMax = 1;
        iMin = 1;

        for (int i=0; i<nums.length; i++) {
            iMax = Math.max(iMax * nums[i], iMin * nums[i]);
            iMin = Math.min(iMax * nums[i], iMin * nums[i]);
            iMax = Math.max(iMax, nums[i]);
            iMin = Math.min(iMin, nums[i]);
            max = Math.max(iMax, max);
        }

        return max;
    }
}
