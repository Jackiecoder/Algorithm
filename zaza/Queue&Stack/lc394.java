package QueueAndStack;

import java.util.Stack;

public class lc394 {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Object> st = new Stack<>();
        char[] sc = s.toCharArray();
        int num = 0;
        String curString = "";
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (c == '[') {
                st.push(curString);
                curString = "";
                st.push(num);
                num = 0;
            } else if (c == ']') {
                int repeatTime = (int)st.pop();
                StringBuilder sb = new StringBuilder();
                if (st.size() > 0) {
                    sb.append((String)st.pop());
                }
                for (int j = 0; j < repeatTime; j++) {
                    sb.append(curString);
                }
                curString = sb.toString();
            } else if (Character.isDigit(c)) {
                num = num*10 + c - '0';
            } else {
                curString += c;
            }
        }

        return curString;
    }
}
