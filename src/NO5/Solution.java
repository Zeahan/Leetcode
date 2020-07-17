package NO5;

class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int len=0; len<s.length(); len++) {
            for (int left=0; left<s.length()&&left+len<s.length(); left++) {
                int right = left + len;
                if (len == 0) {
                    dp[left][right] = true;
                } else if (len == 1) {
                    dp[left][right] = s.charAt(left) == s.charAt(right);
                } else {
                    dp[left][right] = dp[left+1][right-1] && s.charAt(left) == s.charAt(right);
                }
                if (dp[left][right] && len + 1>result.length()) {
                    result = s.substring(left, right+1);
                }
            }
        }
        return result;
    }
}
