package NO64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        for (int x = grid.length - 1; x>-1; x--) {
            for (int y = grid[0].length - 1; y>-1; y--) {
                int right = (x + 1 < grid.length)?dp[x+1][y]:Integer.MAX_VALUE;
                int down = (y + 1 < grid[0].length)?dp[x][y+1]:Integer.MAX_VALUE;
                dp[x][y] = Math.min(right, down) + grid[x][y];
            }
        }
        return dp[0][0];
    }
}

//class Solution {
//    public int minPathSum(int[][] grid) {
//        int[][] dp = new int[grid.length][grid[0].length];
//
//        for (int y = grid.length - 1; y>-1; y--) {
//            for (int x = grid[0].length - 1; x>-1; x--) {
//                int right = (x + 1 < grid[0].length)?dp[y][x+1]:0;
//                int down = (y + 1 < grid.length)?dp[y+1][x]:0;
//                dp[y][x] = Math.min(right, down) + grid[y][x];
//            }
//        }
//        return dp[0][0];
//    }
//}

class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }


    public static void main(String[] args) throws IOException {
            int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
//        int[][] grid = {{1,2,3}, {4,5,6}, {7,8,9},{10,11,12}};

            int ret = new Solution().minPathSum(grid);

            String out = String.valueOf(ret);

            System.out.print(out);
    }
}