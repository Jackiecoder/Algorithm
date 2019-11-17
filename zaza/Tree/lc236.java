package tree2;

import java.util.Stack;

public class lc236 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        if (l == null && r == null) {
            return null;
        } else if (l != null && r != null) {
            return root;
        } else if (l == null) {
            return r;
        } else {
            return l;
        }
    }

    // using stack
    class Pair{
        int height;
        TreeNode n;
        public Pair(int height, TreeNode n) {
            this.height = height;
            this.n = n;
        }
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode res = null;
        int height = 0;
        Stack<Pair> st = new Stack<>();
        int curHeight = 0;
        TreeNode cur = root;
        while (cur != null || st.size() > 0) {
            while (cur != null) {
                if (cur == q || cur == p) {
                    if (res == null) {
                        res = cur;
                        height = curHeight;
                    } else {
                        return res;
                    }
                }
                st.push(new Pair(curHeight, cur));
                curHeight++;
                cur = cur.left;
            }
            Pair pa = st.pop();
            cur = pa.n;
            curHeight = pa.height;
            if (res != null && curHeight < height) {
                res = cur;
                height = curHeight;
            }
            cur = cur.right;
            curHeight++;
        }

        return null;
    }
}
