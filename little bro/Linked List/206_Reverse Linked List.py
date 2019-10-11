
# iteration method
def reverseList(self, head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    p = head
    q = None
    while p:
        temp = p.next
        p.next = q
        q = p
        p = temp
    return q