package tree2;

import java.util.ArrayList;
import java.util.List;

public class lc113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, sum, res, new ArrayList<>(), 0);
        return res;
    }

    private void helper(TreeNode node, int sum, List<List<Integer>> res, List<Integer> cur, int curSum) {
        cur.add(node.val);
        curSum += node.val;
        if (node.left == null && node.right == null) {
            if (curSum == sum) {
                res.add(new ArrayList<>(cur));
            }
        }
        if (node.left != null) {
            helper(node.left, sum, res, cur, curSum);
        }
        if (node.right != null) {
            helper(node.right, sum, res, cur, curSum);
        }
        cur.remove(cur.size() - 1);
    }
}
