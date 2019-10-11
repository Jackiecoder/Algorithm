package linkedlist;

public class lc143 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            length++;
            cur = cur.next;
        }
        int half = (length + 2 - 1) / 2;
        cur = head;
        while (half > 1) {
            half--;
            cur = cur.next;
        }
        ListNode head2 = reverse(cur.next);
        cur.next = null;
        cur = head;
        while (head2 != null) {
            ListNode temp = cur.next;
            cur.next = head2;
            head2 = head2.next;
            cur.next.next = temp;
            cur = temp;
        }
    }

    private ListNode reverse(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode newHead = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}
