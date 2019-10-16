package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class lc225 {
    private Queue<Integer> q;
    public void MyStack() {
        q = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        while (size > 1) {
            size--;
            q.offer(q.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
