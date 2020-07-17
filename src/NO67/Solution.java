package NO67;

class Solution {
    public String addBinary(String a, String b) {
        String longStr = (a.length() >= b.length())?a:b;
        String shortStr = (a.length() < b.length())?a:b;

        StringBuilder stringBuilder = new StringBuilder();
        int carry=0;
        for (int j=longStr.length()-1; j>-1; j--) {
            int i = j - (longStr.length() - shortStr.length());
            int longBit = Integer.parseInt(String.valueOf(longStr.charAt(j)));
            int shortBit = (i>-1)?Integer.parseInt(String.valueOf(shortStr.charAt(i))):0;
            int bit = longBit + shortBit + carry;
            carry = bit / 2;
            bit = bit % 2;
            stringBuilder.insert(0, bit);
        }
        if (carry == 1) {
            stringBuilder.insert(0, 1);
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}


