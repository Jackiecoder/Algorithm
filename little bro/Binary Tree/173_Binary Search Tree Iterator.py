# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class BSTIterator(object):

    def __init__(self, root):
        """
        :type root: TreeNode
        """
        self.stack = []
        while(root):
            self.stack.append(root)
            root = root.left

    def next(self):
        """
        @return the next smallest number
        :rtype: int
        """
        node = self.stack.pop()
        temp = node.right
        while temp:
            self.stack.append(temp)
            temp = temp.left
        return node.val

    def hasNext(self):
        """
        @return whether we have a next smallest number
        :rtype: bool
        """
        if not self.stack:
            return False
        return True

