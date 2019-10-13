def addTwoNumbers(self, l1, l2):
    """
    :type l1: ListNode
    :type l2: ListNode
    :rtype: ListNode
    """
    dummy = ListNode(0)
    temp = dummy
    p = l1
    q = l2
    carry = 0
    while p and q:
        count = p.val+q.val+carry
        carry = count/10
        count %= 10
        temp.next = ListNode(count)
        temp = temp.next
        p = p.next
        q = q.next
    if p or q:
        temp.next = p or q
        
    while carry:
        if not temp.next:
            temp.next = ListNode(carry)
            break
        else:
            count = temp.next.val + carry
            carry = count/10
            temp.next.val = count%10
            temp = temp.next
    return dummy.next
        
    