def getIntersectionNode(self, headA, headB):
    """
    :type head1, head1: ListNode
    :rtype: ListNode
    """
    if not headA or not headB:
        return None
    p = headA
    q = headB
    while p is not q:
        if p:
            p = p.next
        else:
            p = headB
        if q:
            q = q.next
        else:
            q = headA
    return p
    