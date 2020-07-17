package NO38;

public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        for (int i=1; i<n; i++) {
            result = converter(result);
        }
        return result;
    }

    public String converter(String before) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < before.length()) {

            int j = i + 1;
            while (j < before.length() && before.charAt(i) == before.charAt(j)) {
                j++;
            }
            result.append(String.format("%d%c", j - i, before.charAt(i)));

            if (i == before.length() - 1 && i==j) {
                result.append(String.format("1%c", before.charAt(i)));
            } else {
                i = j;
            }
        }
        return result.toString();
    }
}
