package hash;

import java.util.HashMap;
import java.util.Map;

public class lc205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) {
            return true;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> hash1 = new HashMap<>();
        Map<Character, Integer> hash2 = new HashMap<>();
        int len = s.length();
        if (len == 0) {
            return true;
        }
        for (int i = 0; i < len; i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (!hash1.containsKey(c1) && !hash2.containsKey(c2)) {
                hash1.put(c1, i);
                hash2.put(c2, i);
            } else if (hash1.containsKey(c1) && hash2.containsKey(c2)) {
                if (hash1.get(c1) != hash2.get(c2)) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
