package NO560;

class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;


        if (nums.length == 1 && nums[0] == k) {
            return 1;
        }
        for (int right=1; right<=nums.length; right++) {
            int sum = 0;
            for (int left=0; left<right;left++) {
                for (int i=left; i<right; i++) {
                    sum += nums[i];
                    if (sum == k) {
                        result++;
                        sum = 0;
                    }
                }
            }
        }
        return result;
    }
}
