def evalRPN(self, tokens):
    """
    :type tokens: List[str]
    :rtype: int
    """
    operator = ['+','-','*','/']
    stack = collections.deque()
    for i in tokens:
        if i not in operator:
            stack.append(i)
        else:
            sec = stack.pop()
            fir = stack.pop()
            if i == '+':
                temp = int(fir) + int(sec)
            elif i == '-':
                temp = int(fir) - int(sec)
            elif i == '*':
                temp = int(fir) * int(sec)
            else:
                temp = int(int(fir)/int(sec)) 
                if int(fir)%int(sec) != 0 and int(fir)/int(sec) < 0:
                    temp += 1
            stack.append(temp)
        # print(stack)
    return stack[0]