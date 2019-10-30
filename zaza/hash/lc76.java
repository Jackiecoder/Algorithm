package hash;

import java.util.HashMap;
import java.util.Map;

public class lc76 {
    public String minWindow(String s, String t) {
        if (t == null || t.length() == 0) {
            return "";
        }
        Map<Character, Integer> target = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> cur = new HashMap<>();
        int met = 0;
        int l = -1;
        int r = s.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur.put(c, cur.getOrDefault(c, 0) + 1);
            if (target.getOrDefault(c, 0).equals(cur.get(c))) {
                met++;
            }
            while (met == target.size()) {
                if (r - l > i - j) {
                    r = i;
                    l = j;
                }
                char cc = s.charAt(j++);
                cur.put(cc, cur.get(cc) - 1);
                if (target.containsKey(cc) && cur.get(cc) == target.get(cc) - 1) {
                    met--;
                }
            }
        }
        if (l == -1) {
            return "";
        }

        return s.substring(l, r + 1);
    }
}
