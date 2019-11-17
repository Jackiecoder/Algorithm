package tree2;

import java.util.ArrayList;
import java.util.List;

public class lc173 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class BSTIterator {
        List<Integer> bst;

        public BSTIterator(TreeNode root) {
            bst = new ArrayList<>();
            if (root != null) {
                dfs(root);
            }
        }

        public void dfs(TreeNode cur){
            if (cur == null) {
                return;
            }
            dfs(cur.right);
            bst.add(cur.val);
            dfs(cur.left);
        }

        /** @return the next smallest number */
        public int next() {
            int size = bst.size();
            int cur = bst.get(size - 1);
            bst.remove(size - 1);
            return cur;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            if(bst.size() > 0)
                return true;
            return false;
        }
    }
}
