package NO32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public int longestValidParentheses(String s) {


        int[] dp = new int[s.length()];
        int max = 0;

        for (int i=1; i<s.length(); i++) {
            if (s.charAt(i-1) == '(' && s.charAt(i) == ')') dp[i] = (i>1)?dp[i-2] + 2 : 2;
            if (s.charAt(i-1) == ')' && s.charAt(i) == ')') {
                if (s.charAt(i - dp[i-1] - 1) == '(') {
                    dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }
}

//class Solution {
//    public int longestValidParentheses(String s) {
//        if (s.length() < 2) return 0;
//
//        boolean[][] dp = new boolean[s.length()][s.length()];
//        int maxLen = 0;
//
//        for (int len = 2; len <= s.length(); len += 2) {
//            for (int i=0; i<s.length(); i++) {
//                int j = i + len - 1;
//                if (j >= s.length()) break;
//
//                String current = s.substring(i, j+1);
//                boolean isValid;
//                if (len == 2) {
//                    isValid = (s.charAt(i) == '(' && s.charAt(j) == ')');
//                } else {
//                    isValid = (dp[i+1][j-1] && s.charAt(i) == '(' && s.charAt(j) == ')')
//                            || (dp[i][j-2] && s.charAt(j-1) == '(' && s.charAt(j) == ')')
//                            || (dp[i+2][j] && s.charAt(i) == '(' && s.charAt(i+1) == ')');
//                }
//                dp[i][j] = isValid;
//                if (isValid && len > maxLen) maxLen = len;
//            }
//        }
//        return maxLen;
//    }
//}

class MainClass {
    public static String stringToString(String input) {
        if (input == null) {
            return "null";
        }
        return input;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String s = stringToString(line);

            int ret = new Solution().longestValidParentheses(s);

            String out = String.valueOf(ret);

            System.out.print(out);
        }
    }
}