package hash;

import java.util.*;

public class lc140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, new HashSet(wordDict), 0, new HashMap<Integer, List<String>>());
    }

    private List<String> helper(String s, Set<String> wordDict, int start,
                                Map<Integer, List<String>> indexToList) {
        if (indexToList.containsKey(start)) {
            return indexToList.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))) {
                List<String> temp = helper(s, wordDict, i, indexToList);
                for (String ss : temp) {
                    res.add(s.substring(start, i) + (ss.equals("") ? "" : " ") + ss);
                }
            }
        }
        indexToList.put(start, res);
        return res;
    }
}
