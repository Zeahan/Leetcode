package NO1347;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer> sChars = collectLetters(s);
        HashMap<Character,Integer> tChars = collectLetters(t);

        int diff = 0;
        for (Map.Entry<Character,Integer> entry:sChars.entrySet()) {
            char letter = entry.getKey();
            if (tChars.containsKey(letter)) {
                diff += (sChars.get(letter) > tChars.get(letter))?sChars.get(letter) - tChars.get(letter):0;
            } else {
                diff += sChars.get(letter);
            }
        }

        return diff;
    }
    
    public HashMap<Character,Integer> collectLetters(String s) {
        HashMap<Character,Integer> chars = new HashMap<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (chars.containsKey(c)) {
                chars.put(c, chars.get(c) + 1);
            } else {
                chars.put(c, 1);
            }
        }
        return chars;
    }
}
