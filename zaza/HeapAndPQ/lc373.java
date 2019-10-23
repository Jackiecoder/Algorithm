package HeapAndPQ;

import java.util.*;

public class lc373 {
    public class Pair {
        int x;
        int y;
        int sum;
        public Pair(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length * nums2.length == 0) {
            return res;
        }
        Queue<Pair> pq = new PriorityQueue<>(nums1.length, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(new Pair(0, i, nums1[0] + nums2[i]));
        }
        for (int i = 0; i < k && pq.size() > 0; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(nums1[pq.peek().x]);
            temp.add(nums2[pq.peek().y]);
            res.add(temp);
            Pair cur = pq.poll();
            if (cur.x + 1 < nums1.length) {
                pq.offer(new Pair(cur.x + 1, cur.y, nums1[cur.x + 1] + nums2[cur.y]));
            }
        }

        return res;
    }
}
