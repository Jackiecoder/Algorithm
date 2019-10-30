package hash;

import java.util.HashSet;
import java.util.Set;

public class lc3 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Set<Character> letter = new HashSet<>();
        int res = 0;
        for (int i = 0, j = 0; j <= i && i < s.length(); i++) {
            char c = s.charAt(i);
            if (letter.contains(c)) {
                char cc = s.charAt(j);
                while (cc != c) {
                    letter.remove(cc);
                    cc = s.charAt(++j);
                }
                j++;
            } else {
                letter.add(c);
            }
            res = Math.max(res, letter.size());
        }

        return res;
    }
}
