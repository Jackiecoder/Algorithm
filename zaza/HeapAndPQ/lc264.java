package HeapAndPQ;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class lc264 {
    public int nthUglyNumber(int n) {
        Queue<Long> pq = new PriorityQueue<>();
        Set<Long> hashset = new HashSet<>();
        pq.offer(Long.valueOf(1));
        for (int i = 0; i < n - 1; i++) {
            long cur = pq.poll();
            if (hashset.add(cur*2)) {
                pq.offer(cur*2);
            }
            if (hashset.add(cur*3)) {
                pq.offer(cur*3);
            }
            if (hashset.add(cur*5)) {
                pq.offer(cur*5);
            }
        }
        int res = pq.poll().intValue();
        return res;
    }
}
