package NO69;

class Solution {
    public int mySqrt(int x) {
        double left = 0;
        double right = x;
        double mid = 0;

        if (x == 0 || x == 1) {
            return x;
        }
        while (left < right) {
            mid = left + (right - left + 0.01)  / 2;
            if (x / mid == mid || Math.abs(x / mid - mid) < 0.01) {
                break;
            }
            if (x / mid < mid) {
                right = mid;
            }
            if (x / mid > mid) {
                left = mid;
            }
        }

        return (int) mid;
    }
}
