package linkedlist;

public class lc25 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode nextHead = head;
        for (int i = 0; i < k; i++) {
            nextHead = nextHead.next;
            if (nextHead == null && i != k - 1) {
                return head;
            }
        }
        ListNode newHead = null;
        ListNode cur = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = temp;
        }
        head.next = reverseKGroup(nextHead, k);

        return newHead;
    }
}
