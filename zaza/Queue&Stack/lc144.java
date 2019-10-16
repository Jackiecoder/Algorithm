package QueueAndStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class lc144 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            res.add(root.val);
            if (root.right != null) {
                stack.push(root.right);
            }
            root = root.left;
            if (root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }
        return res;
    }
}
