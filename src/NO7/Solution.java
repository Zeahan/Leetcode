package NO7;

//class Solution {
//    public int reverse(int x) {
//        long lx = (long)x;
//        // the string format of the int
//        String str = Long.toString((lx>0)?lx:-lx);
//        // the reversed number
//        long reversed = 0;
//        for (int i=0; i < str.length(); i++) {
//            int bit = Integer.parseInt(String.valueOf(str.charAt(i)));
//            reversed += bit * Math.pow(10, i);
//        }
//
//        reversed = (x > 0)? reversed:-reversed;
//        reversed = (reversed > - Math.pow(2, 31) && reversed < Math.pow(2, 31) - 1)?reversed:0;
//        return (int)reversed;
//    }
//}

class Solution {
    public int reverse(int x) {
        long lx = (long)x;
        // the string format of the int
        String str = Long.toString((lx>0)?lx:-lx);

        String reversedStr = new StringBuffer(str).reverse().toString();

        long reversed = Long.parseLong(reversedStr);
        reversed = (x > 0)? reversed:-reversed;
        reversed = (reversed > - Math.pow(2, 31) && reversed < Math.pow(2, 31) - 1)?reversed:0;

        return (int)reversed;
    }
}

