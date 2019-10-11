package linkedlist;

public class lc426 {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    ;

    Node first = null;
    Node last = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        inorder(root);
        first.left = last;
        last.right = first;
        return first;
    }

    private void inorder(Node n) {
        if (n == null) {
            return;
        }
        inorder(n.left);
        if (last == null) {
            first = n;
        } else {
            last.right = n;
            n.left = last;
        }
        last = n;
        inorder(n.right);
    }
}
