package tree2;

import java.util.Stack;

public class lc230 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int kthSmallest(TreeNode root, int k) {
        int cnt = 0;
        Stack<TreeNode> st = new Stack<>();
        while (root != null || st.size() > 0) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            cnt++;
            if (cnt == k) {
                return root.val;
            }
            root = root.right;
        }

        return 0;
    }
}
