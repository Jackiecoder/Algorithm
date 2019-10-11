package linkedlist;

public class lc61 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int length = 1;
        ListNode last = head;
        while (last.next != null) {
            length++;
            last = last.next;
        }
        k = k%length;
        if (k == 0) {
            return head;
        }
        k = length - k;
        ListNode cur = head;
        while (k > 1) {
            k--;
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        last.next = head;

        return newHead;
    }
}
