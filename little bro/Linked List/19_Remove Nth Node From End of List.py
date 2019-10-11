def removeNthFromEnd(self, head, n):
        """
        :type head: ListNode
        :type n: int
        :rtype: ListNode
        """    
        # two pointer
        if n<=0:
            return head
        dummy = ListNode(0)
        dummy.next = head
        p1 = dummy 
        p2 = dummy
        for i in range(n):
            p2 = p2.next
        while p2.next:
            p1 = p1.next 
            p2 = p2.next
        p1.next = p1.next.next
        return dummy.next