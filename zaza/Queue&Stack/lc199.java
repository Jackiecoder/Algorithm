package QueueAndStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc199 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int curSize = q.size();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = q.poll();
                if (i == curSize - 1) {
                    res.add(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        return res;
    }
}
