package hash;

import java.util.*;

public class lc49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        Map<String, List<String>> wordToList = new HashMap<>();
        for (String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);
            if (!wordToList.containsKey(key)) {
                wordToList.put(key, new ArrayList<>());
            }
            wordToList.get(key).add(s);
        }

        return new ArrayList<>(wordToList.values());
    }
}
