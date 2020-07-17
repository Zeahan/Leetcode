package NO76;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        // Set<Character> target = new HashSet<>();
        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> current = new HashMap<>();
        int min = -1;
        int minLeft = 0;
        int minRight = 0;
        boolean reachTarget = false;
        for (int i=0; i<t.length(); i++) {
            target.put(t.charAt(i), (target.containsKey(t.charAt(i)))?target.get(t.charAt(i))+1:1);
        }

        int j = 0;
        for (int i=0; i<s.length(); i++) {
            if (target.containsKey(s.charAt(i)) ) {
                if (!current.containsKey(s.charAt(i))) {
                    current.put(s.charAt(i), 1);
                } else {
                    current.put(s.charAt(i), current.get(s.charAt(i)) + 1);
                }
            }

            while(j <=i && (!target.containsKey(s.charAt(j)) || (current.containsKey(s.charAt(j)) && current.get(s.charAt(j)) >target.get(s.charAt(j))))) {
                if ((current.containsKey(s.charAt(j)) && current.get(s.charAt(j)) > target.get(s.charAt(j)))) {
                    current.put(s.charAt(j), current.get(s.charAt(j)) - 1);
                }
                j++;
            }

            reachTarget= true;
            for (char key:target.keySet()) {
                if ((!current.containsKey(key)) || current.get(key) < target.get(key)) {
                    reachTarget = false;
                }
            }

            if (min == -1 && reachTarget) {
                min = i-j+1;
            }



            if (reachTarget && i-j+1 <= min) {
                min = i-j+1;
                minLeft = j;
                minRight = i;
            }
        }

//        reachTarget = true;
//        for (char key:current.keySet()) {
//            if (current.get(key) < target.get(key)) {
//                reachTarget = false;
//            }
//        }
        if (reachTarget) {
            return s.substring(minLeft, minRight+1);
        } else {
            return "";
        }

    }
}