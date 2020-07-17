package NO912;

import java.util.Arrays;

class Solution {
    // 1.冒泡排序（超出时间限制）
    // public int[] sortArray(int[] nums) {
    //     // 共排序n-1次
    //     for (int i=0; i<nums.length-1; i++) {
    //         // 排序的标记
    //         boolean flag = true;
    //         // j+1的最大值为无序区的末尾 n-i, j的最大值是n-i-1
    //         for (int j=0; j < nums.length - 1 - i; j++) {
    //             // 两两交换
    //             if (nums[j] > nums[j+1]) {
    //                 int temp = nums[j];
    //                 nums[j] = nums[j+1];
    //                 nums[j+1] = temp;
    //                 flag = false;
    //             }
    //         }
    //         // 如果当前没有发生排序，证明排序已完成，提前终止
    //         if (flag) break;
    //     }
    //     return nums;
    // }

    // // 2.选择排序
    // public int[] sortArray(int[] nums) {
    //     // 排序完成前，有序区的最大右边界为n-1(排除末尾元素)
    //     for (int i=0; i<nums.length-1; i++) {
    //         // 当前最小元素的下标（开始为无序区的第一个元素）
    //         int indexOfMin = i;
    //         // 从无序区的第二个元素开始（i+1), 与当前最小元素进行比较，并记录下标
    //         for (int j=i+1; j<nums.length; j++) {
    //             if (nums[j] < nums[indexOfMin]) {
    //                 indexOfMin = j;
    //             }
    //         }
    //         // 将当前无序区的最小元素移到最前
    //         int temp = nums[i];
    //         nums[i] = nums[indexOfMin];
    //         nums[indexOfMin] = temp;
    //     }
    //     return nums;
    // }

    // 3.插入排序
    // public int[] sortArray(int[] nums) {
    //     for (int i=1; i<nums.length; i++) {
    //         int j = i;
    //         // 无序区的首个元素
    //         int temp = nums[j];
    //         // 从有序区的末尾开始，不断前移直到找到比自己小的元素
    //         while (j > 0 && nums[j-1] > temp) {
    //             // 所有大元素后移一位
    //             nums[j] = nums[j-1];
    //             j--;
    //         }
    //         // 插入当前位置
    //         nums[j] = temp;
    //     }
    //     return nums;
    // }

    // 4.希尔排序
    // public int[] sortArray(int[] nums) {
    //     // 计算gap，从n/2到1
    //     for (int gap=nums.length/2; gap>0; gap /= 2) {
    //         // 针对每一种gap执行一次插入排序
    //         // 每次移动的距离由1变为gap
    //         for (int i=gap; i<nums.length; i+=gap) {
    //             int j=i;
    //             int temp = nums[j];
    //             while (j > 0 && nums[j-gap] > temp) {
    //                 nums[j] = nums[j-gap];
    //                 j -= gap;
    //             }
    //             nums[j] = temp;
    //         }
    //     }
    //     return nums;
    // }

    // 5.归并排序
    public int[] sortArray(int[] nums) {
        // 边界
        if (nums.length < 2) return nums;
        // 左半部
        int[] left = Arrays.copyOfRange(nums,0, nums.length/2);
        // 右半部
        int[] right = Arrays.copyOfRange(nums,nums.length/2, nums.length);
        // 左右数组先排序后合并
        return mergeArray(sortArray(left), sortArray(right));
    }

    public int[] mergeArray(int[] a1, int[] a2) {

        int[] res = new int[a1.length + a2.length];
        int p1 = 0;
        int p2 = 0;

        for (int i=0; i<res.length; i++) {
            // 某数组遍历到末尾的情况
            if (p1 >= a1.length && p2 >= a2.length) {
                break;
            } else if (p1 >= a1.length) {
                res[i] = a2[p2];
                p2++;
                continue;
            } else if (p2 >= a2.length) {
                res[i] = a1[p1];
                p1++;
                continue;
            }

            // 比较大小，向合并数组中插入数据，然后移动指针
            if (a1[p1] <= a2[p2]) {
                res[i] = a1[p1];
                p1++;
            } else {
                res[i] = a2[p2];
                p2++;
            }
        }

        return res;
    }
}

