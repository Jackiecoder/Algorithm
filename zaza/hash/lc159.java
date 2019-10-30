package hash;

import java.util.HashMap;
import java.util.Map;

public class lc159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> letterToFreq = new HashMap<>();
        int res = 0;
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            letterToFreq.put(c, letterToFreq.getOrDefault(c, 0) + 1);
            while (letterToFreq.size() > 2) {
                char cc = s.charAt(j++);
                int freq = letterToFreq.get(cc) - 1;
                if (freq == 0) {
                    letterToFreq.remove(cc);
                } else {
                    letterToFreq.put(cc, freq);
                }
            }
            res = Math.max(res, i - j + 1);
        }

        return res;
    }
}
