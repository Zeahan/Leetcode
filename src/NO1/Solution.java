package NO1;

import java.util.HashMap;


//class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> numsAndIndexes = new HashMap<>();
//        HashMap<Integer, Integer> duplicatedNumsAndIndexes = new HashMap();
//        int[] solution;
//        for (int i = 0; i < nums.length; i++) {
//            if (numsAndIndexes.get(nums[i]) == null) {
//                numsAndIndexes.put(nums[i], i);
//            }
//            else {
//                duplicatedNumsAndIndexes.put(nums[i], i);
//            }
//        }
//
//        for (int num : nums) {
//
//            int num2 = target - num;
//            int index1 = numsAndIndexes.get(num);
//
//            if (numsAndIndexes.get(num2) != null && target != 2 * num) {
//                return new int[]{index1, numsAndIndexes.get(num2)};
//            } else if (duplicatedNumsAndIndexes.get(num2) != null) {
//                return new int[]{index1, duplicatedNumsAndIndexes.get(num2)};
//            }
//        }
//        return null;
//    }
//}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}