class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        
        # NOT mine DP solution
        n = len(s)
        res = [False]*n
        for i in range(n):
            for w in wordDict:
                if (s[i-len(w)+1:i+1] == w) and (res[i-len(w)] or i-len(w) == -1):
                    res[i] = True
        return res[-1]