'''
可以用string.split('/') 较方便的分隔开 string
'''
def simplifyPath(self, path):
        '''
        easy split slash method
        '''
        ls = [p for p in path.split('/') if p != '.' and p!= '']
        print(ls)
        stack = []
        for ele in ls:
            if ele == '..': 
                if len(stack) != 0:
                    stack.pop()
            else:
                stack.append(ele)
        return '/'+'/'.join(stack)
    

'''
自己做的解法， 手动分隔开 string 和 / 
'''
def simplifyPath(self, path):
    """
    :type path: str
    :rtype: str
    """
    stack = collections.deque()
    name = ''
    last = ''
    for s in path:
        # print(s, stack)
        if s == '/':
            if len(stack) == 0 or stack[-1] != s:
                stack.append(s)
            elif len(name) == 0:
                continue
            else:
                slash = stack.pop()
                stack.append(name)
                stack.append(slash)
                name = ''
        else:
            name += s
    if len(name):
        stack.append(name)
    res = []
    for ele in stack:
        if ele == '..':
            if len(res) == 0:
                continue
            else:
                res.pop()
        elif ele == '/' or ele == '.':
            continue
        else:
            res.append(ele)
    return '/'+'/'.join(res)
        
        