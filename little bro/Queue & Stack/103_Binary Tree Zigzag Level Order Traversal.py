def zigzagLevelOrder(self, root):
    """
    :type root: TreeNode
    :rtype: List[List[int]]
    """
    res = []
    def helper(node, lvl):
        if node:
            if len(res)<= lvl:
                res.append([])
            if lvl%2 == 0:
                res[lvl] += [node.val]
            else:
                res[lvl] = [node.val]+res[lvl]
            helper(node.left, lvl+1)
            helper(node.right, lvl+1)
    helper(root, 0)
    return res