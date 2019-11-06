# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def generateTrees(self, n):
        """
        :type n: int
        :rtype: List[TreeNode]
        """
        def rec(l, r):
            if l > r:
                return [None]
            temp_res = []
            for i in range(l,r+1):
                for lnode in rec(l, i-1):
                    for rnode in rec(i+1, r):
                        root = TreeNode(i)
                        root.left = lnode
                        root.right = rnode
                        temp_res += [root]
            return temp_res
        return rec(1, n)
