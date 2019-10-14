'''
1. Recursion:
Hint:
    1. defining function within function is a good way to use recursion
    2. variable "level" is helpful for binary tree
'''
def levelOrder(root):
    """
    :type root: TreeNode
    :rtype: List[List[int]]
    """
    res = []
    def helper(node, lvl):
        if node:
            if len(res) <= lvl:
                res.append([])
            res[lvl] += [node.val]
            helper(node.left, lvl+1)
            helper(node.right, lvl+1)
    helper(root, 0)
    return res