'''
Compare with 225
'''
class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = collections.deque()
        self.stack_temp = collections.deque()
        

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: None
        """
        stack = self.stack
        stack_temp = self.stack_temp
        for _ in range(len(stack)):
            stack_temp.append(stack.pop())
        stack.append(x)
        for _ in range(len(stack_temp)):
            stack.append(stack_temp.pop())
        

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        stack = self.stack
        return stack.pop()
        

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        stack = self.stack
        res = stack.pop()
        stack.append(res)
        return res
        

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        stack = self.stack
        return not bool(len(stack))

