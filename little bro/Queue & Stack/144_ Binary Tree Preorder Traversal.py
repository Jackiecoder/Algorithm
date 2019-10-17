def preorderTraversal(self, root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """
    
    '''
    iteration method
    '''
    res = []
    if not root:
        return res
    stack = collections.deque()
    stack.append(root) 
    while stack:
        top = stack.pop()
        res.append(top.val)
        if top.right:
            stack.append(top.right)
        if top.left:
            stack.append(top.left)
    return res
    
    '''
    recursion method
    ''' 
    res = []
    def helper(node):
        if node:
            res.append(node.val)
            helper(node.left)
            helper(node.right)
    helper(root)
    return res