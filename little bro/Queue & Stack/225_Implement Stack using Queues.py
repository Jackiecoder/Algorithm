class MyStack(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.stack = collections.deque()

    def push(self, x):
        """
        Push element x onto stack.
        :type x: int
        :rtype: None
        """
        stack = self.stack
        stack.append(x)
        for _ in range(len(stack)-1):
            stack.append(stack.popleft())

    def pop(self):
        """
        Removes the element on top of the stack and returns that element.
        :rtype: int
        """
        stack = self.stack
        return stack.popleft()
        

    def top(self):
        """
        Get the top element.
        :rtype: int
        """
        stack = self.stack
        return stack[0]
        

    def empty(self):
        """
        Returns whether the stack is empty.
        :rtype: bool
        """
        stack = self.stack
        return 1-bool(len(stack))
    