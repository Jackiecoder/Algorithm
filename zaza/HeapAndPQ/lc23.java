package HeapAndPQ;

import java.util.PriorityQueue;
import java.util.Queue;

public class lc23 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        Queue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode cur = dummy;
        while (pq.size() > 1) {
            ListNode temp = pq.poll();
            cur.next = temp;
            cur = cur.next;
            if (temp.next != null) {
                pq.offer(temp.next);
            }
        }
        cur.next = pq.poll();

        return dummy.next;
    }
}
