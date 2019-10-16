package QueueAndStack;

import java.util.Stack;

public class lc856 {
    public int scoreOfParentheses(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        Stack<Object> st = new Stack<>();
        char[] sc = S.toCharArray();
        int num = 0;
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (c == '(') {
                if (num != 0) {
                    st.push(num);
                    num = 0;
                }
                st.push(c);
            } else {
                if (st.peek() instanceof Character) {
                    st.pop();
                    if (num == 0) {
                        num = 1;
                    } else {
                        num *= 2;
                    }
                    if (st.size() > 0 && st.peek() instanceof Integer) {
                        num += (int)st.pop();
                    }
                }
            }
        }

        return num;
    }

    /*
    public int scoreOfParentheses(String S) {
    Stack<Integer> stack = new Stack();
    stack.push(0); // The score of the current frame

    for (char c: S.toCharArray()) {
        if (c == '(')
            stack.push(0);
        else {
            int v = stack.pop();
            int w = stack.pop();
            stack.push(w + Math.max(2 * v, 1));
        }
    }

    return stack.pop();
    }
    * */
}
