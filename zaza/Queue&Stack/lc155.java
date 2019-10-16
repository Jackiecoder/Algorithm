package QueueAndStack;

import java.util.Stack;

public class lc155 {
    class MinStack {

        /** initialize your data structure here. */
        Stack<Integer> st;
        Stack<Integer> minSt;
        public MinStack() {
            st = new Stack<>();
            minSt = new Stack<>();
        }

        public void push(int x) {
            st.push(x);
            if (minSt.size() == 0) {
                minSt.push(x);
            } else {
                minSt.push(Math.min(minSt.peek(), x));
            }
        }

        public void pop() {
            st.pop();
            minSt.pop();
        }

        public int top() {
            return st.peek();
        }

        public int getMin() {
            return minSt.peek();
        }
    }
}
