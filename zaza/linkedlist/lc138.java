package linkedlist;

import java.util.HashMap;
import java.util.Map;

// optimized - space O(1), a-a'-b-b'-c-c'

public class lc138 {

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {}

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }

    //iteratively
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> dict = new HashMap<>();
        Node p1 = head;
        Node p2 = null;
        while (p1 != null) {
            if (!dict.containsKey(p1)) {
                Node newNode = new Node(p1.val, null, null);
                dict.put(p1, newNode);
                if (p2 != null) {
                    p2.next = newNode;
                }
                p2 = newNode;
            }
            p1 = p1.next;
        }
        p1 = head;
        p2 = dict.get(p1);
        while (p1 != null) {
            if (p1.random != null) {
                p2.random = dict.get(p1.random);
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return dict.get(head);
    }

    // recursively
    Map<Node, Node> hash = new HashMap<Node, Node>();
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }
        if (hash.containsKey(head)) {
            return hash.get(head);
        }

        Node newHead = new Node(head.val, null, null);
        hash.put(head, newHead);
        newHead.next = copyRandomList2(head.next);
        newHead.random = copyRandomList2(head.random);

        return newHead;
    }

    // space O(1)
    public Node copyRandomList3(Node head) {

        if (head == null) {
            return null;
        }

        // Creating a new weaved list of original and copied nodes.
        Node ptr = head;
        while (ptr != null) {

            // Cloned node
            Node newNode = new Node(ptr.val, null, null);

            // Inserting the cloned node just next to the original node.
            // If A->B->C is the original linked list,
            // Linked list after weaving cloned nodes would be A->A'->B->B'->C->C'
            newNode.next = ptr.next;
            ptr.next = newNode;
            ptr = newNode.next;
        }

        ptr = head;

        // Now link the random pointers of the new nodes created.
        // Iterate the newly created list and use the original nodes' random pointers,
        // to assign references to random pointers for cloned nodes.
        while (ptr != null) {
            ptr.next.random = (ptr.random != null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        // Unweave the linked list to get back the original linked list and the cloned list.
        // i.e. A->A'->B->B'->C->C' would be broken to A->B->C and A'->B'->C'
        Node ptr_old_list = head; // A->B->C
        Node ptr_new_list = head.next; // A'->B'->C'
        Node head_old = head.next;
        while (ptr_old_list != null) {
            ptr_old_list.next = ptr_old_list.next.next;
            ptr_new_list.next = (ptr_new_list.next != null) ? ptr_new_list.next.next : null;
            ptr_old_list = ptr_old_list.next;
            ptr_new_list = ptr_new_list.next;
        }
        return head_old;
    }

}
