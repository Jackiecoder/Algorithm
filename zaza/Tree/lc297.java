package tree2;

import java.util.LinkedList;
import java.util.Queue;

public class lc297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (q.size() > 0) {
            TreeNode cur = q.poll();
            if (cur == null) {
                sb.append("null,");
                continue;
            }
            sb.append(cur.val+",");
            q.offer(cur.left);
            q.offer(cur.right);
        }
        String res = sb.toString();

        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        TreeNode root = null;
        String[] dataArr = data.split(",");
        root = helper(dataArr);

        return root;
    }

    private TreeNode helper(String[] data) {
        int index = 0;
        TreeNode root = new TreeNode(Integer.valueOf(data[index++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (index < data.length) {
            TreeNode cur = q.poll();
            String temp = data[index++];
            if (!temp.equals("null")) {
                int val = Integer.valueOf(temp);
                TreeNode newNode = new TreeNode(val);
                cur.left = newNode;
                q.offer(newNode);
            }
            if (index == data.length) {
                break;
            }
            temp = data[index++];
            if (!temp.equals("null")) {
                int val = Integer.valueOf(temp);
                TreeNode newNode = new TreeNode(val);
                cur.right = newNode;
                q.offer(newNode);
            }
        }

        return root;
    }
}
