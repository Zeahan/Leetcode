package NO20;

import java.util.Arrays;

class Solution {

    public boolean isValid(String s) {
        String[] pairs = new String[]{"()", "{}", "[]"};
        s = s.replace(" ", "");
        if (s.length() % 2 == 1) {
            return false;
        }

        int lenRec = s.length();

        while (s.length() > 2) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");

            if (s.length() == 0) {
                return true;
            } else if (s.length() == lenRec) {
                return false;
            }
            lenRec = s.length();
        };

        return (s.length() == 0 || Arrays.asList(pairs).contains(s));
    }
}
