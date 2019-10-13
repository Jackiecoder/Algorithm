'''
两个知识点:
1. 如何reverse
    1. p = 头
    2. q = None
    3.循环
        temp = p.next 
        p.next = q
        p = temp
        q = p
    4. 最后的结果： q = 6 -> 5 -> 4 -> 3 ..... , 
                  p = 7 -> 8 -> 9 -> .....
'''

def reverseBetween(self, head, m, n):
    """
    :type head: ListNode
    :type m: int
    :type n: int
    :rtype: ListNode
    """

    dummy = ListNode(0)
    dummy.next = head
    temp = dummy
    for i in range(m-1):
        temp = temp.next
    q = None
    p = temp.next
    for i in range(n-m+1):
        store = p.next
        p.next = q
        p, q = store, p
    temp.next.next = p
    temp.next = q

    return dummy.next
            