package NO680;

class Solution {
    public boolean validPalindrome(String s) {
        if (s.length() == 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1))) {
            return true;
        }

        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            return validPalindrome(s.substring(1, s.length() - 1));
        } else if (s.charAt(1) == s.charAt(s.length() - 1)) {
            return validPalindrome(s.substring(2, s.length() - 1));
        } else if (s.charAt(0) == s.length() - 2) {
            return validPalindrome(s.substring(1, s.length() - 2));
        } else {
            return false;
        }
    }
}
