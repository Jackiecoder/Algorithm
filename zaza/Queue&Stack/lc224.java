package QueueAndStack;

import java.util.Stack;

public class lc224 {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Stack<Integer> st = new Stack<>();
        char[] sc = s.toCharArray();
        int sum = 0;
        int num = 0;
        int sign = 1; // 0:- , 1:+
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (c == ' ') {
                continue;
            }
            if (c == '(') {
                st.push(sum);
                sum = 0;
                st.push(sign);
                sign = 1;
            } else if (c == ')') {
                if (sign == 0) {
                    num = -1 * num;
                }
                sum += num;
                num = 0;
                sign = 1;
                int tempS = st.pop();
                int tempN = st.pop();
                if (tempS == 0) {
                    sum = -1 * sum;
                }
                sum = tempN + sum;
            } else if (c == '-') {
                if (sign == 0) {
                    sum += -1*num;
                } else {
                    sum += num;
                }
                num = 0;
                sign = 0;
            } else if (c == '+') {
                if (sign == 0) {
                    sum += -1*num;
                } else {
                    sum += num;
                }
                num = 0;
                sign = 1;
            } else {
                num = num*10 + c - '0';
            }
        }

        if (sign == 0) {
            num = -1* num;
        }

        return sum + num;
    }
}
