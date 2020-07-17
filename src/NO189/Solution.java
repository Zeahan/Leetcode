package NO189;

import java.net.Socket;
import java.util.Arrays;

class Solution {
    public static void rotate(int[] nums, int k) {
        if (nums.length % k == 0) {
            for (int i=0; i<k; i++) {
                int curIndex = i;
                int cur = nums[curIndex];
                do {
                    int targetIndex = (curIndex + k) % nums.length;
                    int temp = nums[targetIndex];
                    nums[targetIndex] = cur;
                    cur = temp;
                    curIndex = targetIndex;
                } while (curIndex != i);
            }
            return;
        }

        int curIndex = 0;
        int cur = nums[curIndex];
        for(int i=0; i<nums.length; i++) {
            int targetIndex = (curIndex + k) % nums.length;
            int temp = nums[targetIndex];
            nums[targetIndex] = cur;
            cur = temp;
            curIndex = targetIndex;
        }
    }
}

class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        int k = 2;
        Solution.rotate(nums,k);
        System.out.println(Arrays.toString(nums));
    }
}
