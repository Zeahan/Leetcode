package NO62;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    int[][] dp;
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return helper(m - 1, n - 1);
    }

    public int helper(int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (x == 0 && y == 0) return 1;
        if (dp[x][y] != 0) return dp[x][y];
//        if ((x == 1 && y == 0) || (x == 0 && y == 1)) {
//             dp[x][y] = 1;
//             return 1;
//        }
        return helper(x - 1, y) + helper(x, y - 1);
    }
}

class MainClass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int m = Integer.parseInt(line);
            line = in.readLine();
            int n = Integer.parseInt(line);

            int ret = new Solution().uniquePaths(m, n);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}
