package NO53;

class Solution {
    public int maxSubArray(int[] nums) {
        int result = 0;
        int left = 0;
        int temp = 0;
        for (int i=0; i<nums.length; i++) {
            temp += nums[i];
            while (nums[left] < 0 && left < i) {
                temp -= nums[left];
                left++;
            }
            result = Math.max(temp, result);
        }
        return result;
    }
}
