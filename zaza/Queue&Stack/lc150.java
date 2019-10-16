package QueueAndStack;

import java.util.Stack;

public class lc150 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int temp = st.pop();
                temp += st.pop();
                st.push(temp);
            } else if (tokens[i].equals("-")) {
                int temp = -1 * st.pop();
                temp += st.pop();
                st.push(temp);
            } else if (tokens[i].equals("*")) {
                int temp = st.pop();
                temp *= st.pop();
                st.push(temp);
            } else if (tokens[i].equals("/")) {
                int temp = st.pop();
                int temp2 = st.pop();
                st.push(temp2 / temp);
            } else {
                st.push(Integer.valueOf(tokens[i]));
            }
        }

        return st.pop();
    }
}
