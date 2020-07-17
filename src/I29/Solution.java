package I29;

public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int width = matrix[0].length;
        System.out.println(width);
        int height = matrix.length;
        int[] res = new int[width*height];


        int i = 0;
        int xStart = 0;
        int yStart = 0;
        while(i<res.length) {
            int x = xStart;
            int y = yStart;
            while(x < width + xStart && i<res.length) {
                res[i] = matrix[y][x];
                x++;
                i++;
            }
            x--;
            y++;
            while (y < height + yStart && i<res.length) {
                res[i] = matrix[y][x];
                y++;
                i++;
            }
            y--;
            x--;
            while (x >= xStart && i<res.length) {
                res[i] = matrix[y][x];
                x--;
                i++;
            }
            x++;
            y--;
            while (y >= yStart + 1 && i<res.length) {
                res[i] = matrix[y][x];
                y--;
                i++;
            }
            y++;
            x++;

            width -= 2;
            height -= 2;
            xStart++;
            yStart++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[][]matrix;
        Solution solution;
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution = new Solution();
        solution.spiralOrder(matrix);
    }
}


