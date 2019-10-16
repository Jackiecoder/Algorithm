package QueueAndStack;

import java.util.LinkedList;
import java.util.Queue;

public class lc346 {
    class MovingAverage {

        /** Initialize your data structure here. */
        public int size;
        Queue<Integer> q;
        private double sum;
        public MovingAverage(int size) {
            this.size = size;
            q = new LinkedList<>();
            sum = 0;
        }

        public double next(int val) {
            q.offer(val);
            sum += val;
            if (q.size() > size) {
                sum -= q.poll();
            }

            return sum / q.size();
        }
    }
}
