class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        # second time
        dic = {}
        l = 0
        res = 0
        for r in range(len(s)):
            dic[s[r]] = dic.get(s[r],0)+1
            while dic[s[r]] == 2:
                dic[s[l]] = dic.get(s[l]) - 1
                if dic.get(s[l]) == 1:
                    l += 1
                    break
                l += 1
            res = max(r-l+1, res)
        return res
                
                