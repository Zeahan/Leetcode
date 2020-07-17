package NO50;

class Solution {
    double x;
    public double myPow(double x, int n) {
        this.x = x;
        double result;
        if (x == 0 || x == 1) return x;
        if (n == 0) return 1;
        result = helper(x, Math.abs(n));

        return (n>0)?result:1/result;
    }

    public double helper(double x, int n) {
        if (n == 1) { return x; }

        double y = helper(x, n / 2);
        if (n % 2 == 1) {
            return y * y * this.x;
        } else {
            return y * y;
        }

    }
}
