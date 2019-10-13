
'''     List 
'''
def hasCycle(self, head):
    """
    :type head: ListNode
    :rtype: bool
    """
    # 1. dictionary
    p = head
    visited = []
    while p:
        if p in visited:
            return True
        visited.append(p)
        p = p.next
    return False

'''
        Dictionary (Hash Table)
'''
def hasCycle(self, head):
    p = head
    visited = {}
    while p:
        if p.val in visited and p.next is visited[p.val]:
            return True
        visited[p.val] = p.next
        p = p.next
    return False   


'''
            3. two pointer
'''
def hasCycle(self, head):
    if not head:
        return False
    p = head; q = head.next
    while p is not q:
        if not q or not q.next:
            return False
        p = p.next
        q = q.next.next
    return True