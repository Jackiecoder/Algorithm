class Solution(object):
    def wordBreak(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: List[str]
        """
        res = []
        def recur(st, wordDict, temp_res,res):
            n = len(st)
            if n == 0:
                res.append(temp_res)
            for i in range(n+1):
                for w in wordDict:
                    if st[0:i] == w:
                        recur(st[i:], wordDict, temp_res+" "+w if len(temp_res)>0 else w, res)
        recur(s, wordDict, "", res)
        return res