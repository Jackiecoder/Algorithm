package HeapAndPQ;

import java.util.*;

public class lc347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0 || k == 0) {
            return res;
        }
        Map<Integer, Integer> numToFre = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numToFre.put(nums[i], numToFre.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> pq = new PriorityQueue
                <Integer>((n1, n2) -> numToFre.get(n1) - numToFre.get(n2));
        for (int n : numToFre.keySet()) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (pq.size() > 0) {
            res.add(pq.poll());
        }
        Collections.reverse(res);

        return res;
    }
}
