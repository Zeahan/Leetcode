package NO14;

//class Solution {
//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//        String commonPart = strs[0];
//
//        for (int i=1; i<strs.length; i++) {
//            int j = 0;
//            while (j<(Math.min(strs[i].length(), commonPart.length()))
//                    && commonPart.charAt(j) == strs[i].charAt(j)) {
//                j++;
//            }
//            commonPart = commonPart.substring(0, j);
//        }
//        return commonPart;
//    }
//}
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int curIndex = 0;
        char curChar;

        while (curIndex < strs[0].length()) {
            curChar = strs[0].charAt(curIndex);
            for (int i=1; i<strs.length; i++) {
                if (strs[i].length() <= curIndex || strs[i].charAt(curIndex) != curChar){
                    return strs[0].substring(0, curIndex);
                }
                curIndex++;
            }
        }
        return strs[0].substring(0, curIndex);
    }
}