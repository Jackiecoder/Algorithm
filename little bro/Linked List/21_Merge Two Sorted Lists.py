def mergeTwoLists(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    
    '''
    Second times
    '''
    if not l1:
        return l2
    if not l2:
        return l1
    p = l1; q = l2
    dummy = ListNode(0)
    curr = dummy
    while p and q:
        if p.val<=q.val:
            curr.next = p
            curr = curr.next
            p = p.next
        else:
            curr.next = q
            curr = curr.next
            q = q.next
    print(dummy.next)
    if p:
        curr.next = p
    if q:
        curr.next = q
    return dummy.next
        