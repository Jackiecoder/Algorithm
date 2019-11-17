package tree2;

import java.util.ArrayList;
import java.util.List;

public class lc95 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }

        return helper(1, n);
    }

    private List<TreeNode> helper(int l, int r) {
        List<TreeNode> res = new ArrayList<>();
        if (l > r) {
            res.add(null);
            return res;
        }

        for (int i = l; i <= r; i++) {
            List<TreeNode> leftTree = helper(l, i-1);
            List<TreeNode> rightTree = helper(i+1, r);
            for (TreeNode LT: leftTree) {
                for (TreeNode RT : rightTree) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = LT;
                    cur.right = RT;
                    res.add(cur);
                }
            }
        }

        return res;
    }
}
