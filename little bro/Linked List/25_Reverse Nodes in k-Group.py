def reverseKGroup(self, head, k):
    """
    :type head: ListNode
    :type k: int
    :rtype: ListNode
    """
    if not head:
        return head
    p = head
    leng = 0
    while p:
        leng += 1
        p = p.next
        
    dummy = ListNode(0)
    dummy.next = head
    temp = dummy
    p = dummy.next
    q = None
    for i in range(leng/k):
        q = None
        for j in range(k):
            store = p.next
            p.next = q
            q = p
            p = store
        temp.next.next = p
        temp.next = q
        for i in range(k):
            temp = temp.next
    return dummy.next
