package hash;

import java.util.*;

public class lc187 {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() <= 9) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        map.put('A', 0);
        map.put('C', 1);
        map.put('G', 2);
        map.put('T', 3);
        Set<Integer> hash = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        int template = 0;
        for (int i = 0; i < 9*2; i++) {
            template = template << 1;
            template = template | 1;
        };
        int code = 0;
        boolean firsttime = true;
        for (int i = 0; i < s.length()-9; i++) {
            if (firsttime) {
                for (int j = 0; j < i+9; j++) {
                    code = code << 2;
                    code = code | map.get(s.charAt(j));
                }
                firsttime = false;
            }
            code = code & template;
            code = code << 2;
            code = (code | map.get(s.charAt(i+9)));
            if (hash.add(code)) {
                continue;
            } else {
                repeated.add(s.substring(i,i+10));
            }
        }

        return new ArrayList<String>(repeated);
    }
}
