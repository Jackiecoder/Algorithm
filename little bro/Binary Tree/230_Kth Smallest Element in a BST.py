# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """   
        # method 3
        stack = []
        node = root
        while node or stack:
            while node:
                stack.append(node)
                node = node.left
            node = stack.pop()
            k -= 1
            if k == 0:
                return node.val
            node = node.right

        
        # method 2
        # self.k = k
        # self.res = None
        # def helper(node):
        #     if not node:
        #         return 
        #     helper(node.left)
        #     self.k -= 1
        #     if self.k == 0:
        #         self.res = node.val
        #         return
        #     helper(node.right)
        # helper(root)
        # return self.res
        
        
        # method 1
#         self.k = k
#         self.res = None
#         self.helper(root)
#         return self.res
    
#     def helper(self, node):
#         if not node:
#             return
#         self.helper(node.left)
#         self.k -= 1
#         if self.k == 0:
#             self.res = node.val
#             return 
#         self.helper(node.right)