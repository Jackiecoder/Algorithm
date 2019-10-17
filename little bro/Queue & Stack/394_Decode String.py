def decodeString(self, s):
    """
    :type s: str
    :rtype: str
    """
    stack = []
    temp = ''
    times = ''
    for ch in s:
        if ch == ']':
            while True:
                top = stack.pop()
                if top != '[':
                    temp = top+temp
                else:
                    break
            while len(stack) and '0'<=stack[-1]<='9':
                times = stack.pop()+times
            if len(times) == 0:
                times = 0
            temp *= int(times)
            stack.append(temp)
            times = ''
            temp = ''
        else:
            stack.append(ch)
    return ''.join(stack)
        
        