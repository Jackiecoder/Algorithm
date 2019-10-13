'''
第一次没做出来， 可以重新做
'''


def insertionSortList(self, head):
    """
    :type head: ListNode
    :rtype: ListNode
    """
    dummy = ListNode(0)
    dummy.next = head
    q = head
    while q and q.next:
        p = dummy
        val = q.next.val
        if q.val < val:
            q = q.next
            continue
        while p.next.val < val:
            p = p.next
        temp = q.next
        q.next = q.next.next
        temp.next = p.next
        p.next = temp
    return dummy.next