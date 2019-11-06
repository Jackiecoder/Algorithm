# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def pathSum(self, root, sum):
        """
        :type root: TreeNode
        :type sum: int
        :rtype: List[List[int]]
        """
        def dfs(root, sum, temp_res, res):
            if not root:
                return 
            if not root.left and not root.right and sum == root.val:
                res.append(temp_res+[root.val])
            else:
                dfs(root.left, sum-root.val, temp_res+[root.val], res)
                dfs(root.right, sum-root.val, temp_res+[root.val], res)
        res = []
        dfs(root, sum, [], res)
        return res