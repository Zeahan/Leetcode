package NO3;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) { return 0; }

        String maxStr = "";
        String current = "";
        for (int i=0; i<s.length(); i++) {

            if (!current.contains(String.valueOf(s.charAt(i)))) {
                current += String.valueOf(s.charAt(i));
            } else {
                current = String.valueOf(s.charAt(i));
            }

            if (current.length() > maxStr.length()) {
                maxStr = current;
            }
        }
        return maxStr.length();
    }
}
