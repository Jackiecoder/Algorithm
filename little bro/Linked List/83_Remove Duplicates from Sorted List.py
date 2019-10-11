
### Save maximum to know if list move to larger number

def deleteDuplicates(self, head):
        """
        :type head: ListNode
        :rtype: ListNode
        """
        # 1. temp
        if not head:
            return head
        maxi = head.val
        p = head
        while p and p.next:
            if p.next.val == maxi:
                p.next = p.next.next
            else:
                maxi = p.next.val
                p = p.next
        return head