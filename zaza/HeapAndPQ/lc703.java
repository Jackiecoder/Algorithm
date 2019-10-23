package HeapAndPQ;

import java.util.PriorityQueue;
import java.util.Queue;

public class lc703 {
    class KthLargest {
        private Queue<Integer> pq;
        private int size;
        public KthLargest(int k, int[] nums) {
            pq = new PriorityQueue<>();
            size = k;
            for (int i = 0; i < nums.length; i++) {
                pq.offer(nums[i]);
                if (pq.size() > size) {
                    pq.poll();
                }
            }
        }

        public int add(int val) {
            pq.offer(val);
            if (pq.size() > size) {
                pq.poll();
            }
            return pq.peek();
        }
    }
}
