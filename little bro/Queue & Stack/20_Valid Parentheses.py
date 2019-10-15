'''
这个题目很容易漏掉特殊情况， 在debug时 submit 3次错误：
1. 在循环外直接return True:
    如果“（（（（”， 全都为左括号，那么会直接跳过else判断部分，return True
2. else中没有判断 stack 是否为空：
    如果 stack 为空时，stack.pop()会直接报错。  
'''

def isValid(self, s):
    """
    :type s: str
    :rtype: bool
    """
    '''
    second time
    '''
    left_dic = {'(':1,'[':2,'{':3}
    right_dic = {')':1,']':2,'}':3}
    stack = collections.deque()
    for i in s:
        if i in left_dic:
            stack.append(left_dic[i])
        else:
            if len(stack) == 0:
                return False
            top = stack.pop()
            if right_dic[i] != top:
                return False
    return True if not len(stack) else False
                