package NO88;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p2 > -1) {
            if (p1 < 0) {
                nums1[cur] = nums2[p2];
                p2--;
            } else {
                nums1[cur] = Math.max(nums1[p1], nums2[p2]);
                if (nums1[p1] >= nums2[p2]) {
                    p1--;
                } else {
                    p2--;
                }
            }
            cur--;
        }
    }
}
