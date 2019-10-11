package linkedlist;

public class lc92 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode last = dummy;
        for (int i = 0; i < m - 1; i++) {
            last = last.next;
        }
        ListNode cur = last.next;
        ListNode reversed = null;
        ListNode last2 = null;
        int cnt = n - m;
        while (cnt >= 0) {
            cnt--;
            ListNode temp = cur.next;
            cur.next = reversed;
            reversed = cur;
            cur = temp;
            if (last2 == null) {
                last2 = reversed;
            }
        }
        last.next = reversed;
        last2.next = cur;

        return dummy.next;
    }

}
