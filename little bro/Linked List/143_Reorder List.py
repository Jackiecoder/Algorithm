def reorderList(self, head):
    """
    :type head: ListNode
    :rtype: None Do not return anything, modify head in-place instead.
    """
    if not head:
        return head
    
    # find middle
    slow = head
    fast = head
    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next
    
    # reverse the second half
    p = slow
    q = None
    while p:
        temp = p.next
        p.next = q
        q = p
        p = temp
        
    # merge
    p = head
    while q.next:
        temp1 = p.next
        temp2 = q.next
        p.next = q
        q.next = temp1
        p = temp1
        q = temp2
    return head
        
        