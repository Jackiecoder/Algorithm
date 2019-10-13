'''
original method
'''
def rotateRight(self, head, k):
    """
    :type head: ListNode
    :type k: int
    :rtype: ListNode
    """
    if not head:
        return head
    cur = head
    leng = 0
    while cur:
        leng += 1
        cur = cur.next
    net_k = k % leng
    if net_k == 0:
        return head
    p1 = head 
    p2 = head
    temp = net_k
    while(temp):
        p2 = p2.next
        temp -= 1
    while(p2 and p2.next):
        p1 = p1.next
        p2 = p2.next
    dummy = ListNode(0)
    dummy.next = p1.next
    p2.next = head
    p1.next = None
    return dummy.next

'''
make a circle, and break it
'''
def rotateRight(self, head, k):
    """
    :type head: ListNode
    :type k: int
    :rtype: ListNode
    """
    # method 2, make a circle
    
    if not head:
        return head
    curr = head
    leng = 1
    while(curr and curr.next):
        curr = curr.next
        leng += 1
    curr.next = head
    temp = leng - k%leng
    while(temp):
        curr = curr.next
        temp -= 1
    dummy = ListNode(0)
    dummy.next = curr.next
    curr.next = None
    return dummy.next
        
