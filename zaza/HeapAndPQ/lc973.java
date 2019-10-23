package HeapAndPQ;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc973 {
    public int[][] kClosest(int[][] points, int K) {
        if (points == null || points.length == 0 || points[0].length == 0 || K == 0) {
            return new int[0][0];
        }
        int[][] res = new int[K][2];
        Queue<int[]> pq = new PriorityQueue<>(K, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                int dis1 = a[0]*a[0] + a[1]*a[1];
                int dis2 = b[0]*b[0] + b[1]*b[1];
                return dis2 - dis1;
            }
        });

        for (int i = 0; i < points.length; i++) {
            pq.offer(points[i]);
            if (i >= K) {
                pq.poll();
            }
        }

        for (int i = K - 1; i >= 0; i--) {
            res[i] = pq.poll();
        }

        return res;
    }
}
