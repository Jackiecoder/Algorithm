package HeapAndPQ;

import java.util.PriorityQueue;
import java.util.Queue;

public class lc215 {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < nums.length; i++) {
            if (pq.size() == k) {
                if (pq.peek() < nums[i]) {
                    pq.offer(nums[i]);
                    pq.poll();
                }
            } else {
                pq.offer(nums[i]);
            }
        }

        return pq.peek();
    }
}
