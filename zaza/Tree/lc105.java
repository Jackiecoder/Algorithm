package tree2;

public class lc105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int pl, int pr, int il, int ir) {
        if (pl > pr || il > il) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[pl]);
        if (pl == pr) {
            return node;
        }
        int iIndex = findIndex(preorder[pl], inorder, il);
        int leftLen = iIndex - il;
        node.left = helper(preorder, inorder, pl+1, pl+leftLen, il, iIndex-1);
        node.right = helper(preorder, inorder, pl+leftLen+1, pr, iIndex+1, ir);

        return node;
    }

    private int findIndex(int target, int[] inorder, int start) {
        for (int i = start; i < inorder.length; i++) {
            if (inorder[i] == target) {
                return i;
            }
        }

        return 0;
    }
}
