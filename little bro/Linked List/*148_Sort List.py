
# 迭代深度问题？

def sortList(self, head):
    """
    :type head: ListNode
    :rtype: ListNode
    """        
    return self.split(head)

def split(self,head):
    if not head or not head.next:
        return head
    p = head
    q = head
    while q and q.next:
        p = p.next
        q = q.next.next
    head2 = p.next
    p.next = None
    l = self.split(head)
    r = self.split(head2)
    return self.merge(l, r)
    
    
def merge(self, l, r):
    if not l or not r:
        return l or r
    if l.val > r.val:
        l,r = r,l # make l[0] minimum
    p = l
    q = r
    while p and p.next and q:
        if p.next.val < q.val:
            p = p.next
        else:
            temp = p.next
            p.next = q
            p.next.next = temp
            p = temp
            q = q.next
    l.next = p or q
    return l
            