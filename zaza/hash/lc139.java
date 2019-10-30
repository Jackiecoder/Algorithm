package hash;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        return helper(s, new HashSet(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean helper(String s, Set<String> wordDict, int start, Boolean[] visited) {
        if (start == s.length()) {
            return true;
        }
        if (visited[start] != null) {
            return visited[start];
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i)) &&
                    helper(s, wordDict, i, visited)) {
                return visited[start] = true;
            }
        }

        return visited[start] = false;
    }
}
