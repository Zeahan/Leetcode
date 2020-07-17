package NO15;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int first=0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first-1]) continue;

            int third = nums.length - 1;
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) continue;
                while (second < third && nums[first] + nums[second] + nums[third] > 0) third--;
                if (second == third) break;
                if (nums[first] + nums[second] + nums[third] == 0) res.add(Arrays.asList(nums[first], nums[second], nums[third]));
            }
        }
        return res;
    }
}
