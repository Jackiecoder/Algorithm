package QueueAndStack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc102 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            int curSize = q.size();
            List<Integer> level = new LinkedList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(level);
        }

        return res;
    }
}
