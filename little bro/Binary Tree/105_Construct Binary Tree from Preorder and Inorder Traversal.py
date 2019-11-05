# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def buildTree(self, preorder, inorder):
        """
        :type preorder: List[int]
        :type inorder: List[int]
        :rtype: TreeNode
        """
        if not inorder:
            return
        n = len(inorder)
        for i in range(n):
            if inorder[i] == preorder[0]:
                ind = i
                break
        root = TreeNode(preorder[0])
        root.left = self.buildTree(preorder[1:], inorder[0:ind])
        root.right = self.buildTree(preorder[1+ind:], inorder[ind+1:])
        return root