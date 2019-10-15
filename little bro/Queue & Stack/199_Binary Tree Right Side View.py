'''
1. 遍历后 取每层最后一个值 --> DFS
# runtime 20 ms
'''
def rightSideView(self, root):
    """
    :type root: TreeNode
    :rtype: List[int]
    """

    res = []
    def helper(node, lvl):
        if node:
            if len(res)<= lvl:
                res.append([])
            res[lvl] += [node.val]
            helper(node.left, lvl+1)
            helper(node.right, lvl+1)
    helper(root, 0)
    return [x[-1] for x in res]

'''
2. 算法1 的优化   --> DFS
runtime: 16ms
'''
def rightSideView(self, root):
    res = []
    def helper(node, depth):
        if node:
            if len(res) == depth:
                res.append(node.val)
            helper(node.right, depth+1)
            helper(node.left, depth+1)
    helper(root, 0)
    return res

'''
3. iteration --> BFS
runtime: 24ms
'''
def rightSideView(self, root):
    res = []
    queue = [root] if root else []
    while queue:
        res.append(queue[-1].val)
        queue = [kids for n in queue for kids in (n.left, n.right) if kids]
    return res
