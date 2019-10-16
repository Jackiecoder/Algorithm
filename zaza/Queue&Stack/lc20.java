package QueueAndStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class lc20 {
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        char[] ch = s.toCharArray();
        Map<Character, Integer> hash = new HashMap();
        hash.put('{', 1);
        hash.put('}', -1);
        hash.put('[', 2);
        hash.put(']', -2);
        hash.put('(', 3);
        hash.put(')', -3);
        Stack<Integer> st = new Stack();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (hash.get(c) > 0) {
                st.push(hash.get(c));
            } else {
                if (st.size() == 0 || st.peek() + hash.get(c) != 0) {
                    return false;
                }
                st.pop();
            }
        }
        if (st.isEmpty()) {
            return true;
        }
        return false;
    }
}
