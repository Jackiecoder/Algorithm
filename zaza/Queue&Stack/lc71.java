package QueueAndStack;

import java.util.Stack;

public class lc71 {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        Stack<String> st = new Stack<>();
        int i = 0;
        while (i < path.length()) {
            if (path.charAt(i) != '/') {
                int j = i;
                while (j < path.length() && path.charAt(j) != '/') {
                    j++;
                }
                String s = path.substring(i, j);
                if (s.equals("..") && !st.isEmpty()) {
                    st.pop();
                } else if(!s.equals("..") && !s.equals(".")){
                    st.push(s);
                }
                i = j;
            }
            i++;
        }
        if(st.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.insert(0, "/" + st.pop());
        }

        return sb.toString();
    }
}
