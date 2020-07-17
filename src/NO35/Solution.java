package NO35;

class Solution {
    int[] nums;
    int target;
    public int searchInsert(int[] nums, int target) {
        this.nums = nums;
        this.target = target;

        return helper(0, nums.length - 1);
    }

    public int helper(int left, int right) {
        if (this.nums[left] == target) return left;
        if (this.nums[right] == target) return right;
        if (left + 1 == right) return right;

        int mid = left + (right - left + 1) / 2;

        if (this.nums[mid] == target) return mid;

        return (this.nums[mid]>target)?helper(left, mid):helper(mid, right);
    }
}
