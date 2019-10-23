class Solution(object):
    def scoreOfParentheses(self, S):
        """
        :type S: str
        :rtype: int
        """
        stack = []
        for ch in S:
            if ch == ')':
                score = 0
                while True:
                    # print(stack)
                    temp = stack.pop()                
                    if temp == '(':
                        if score == 0:
                            stack.append(1)
                        else:
                            stack.append(score*2)
                        break
                    else:
                        score += temp
            else:
                stack.append(ch)
        return sum(stack)
                    