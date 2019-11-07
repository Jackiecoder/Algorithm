# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def maxPathSum(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        self.max = None
        def rec(node):
            if not node:
                return 0
            left = rec(node.left)
            right = rec(node.right)
            self.max = max(self.max, left+right+node.val)
            return max(0, node.val+max(left,right))
        rec(root)
        return self.max