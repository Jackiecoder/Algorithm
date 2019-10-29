class Solution(object):
    def lengthOfLongestSubstringTwoDistinct(self, s):
        """
        :type s: str
        :rtype: int
        """
        if len(s)<=2:
            return len(s) 
        l = 0
        r = 1
        n = len(s)
        dic = {s[0]:1}
        res = 0
        while l<r<n:
            dic[s[r]] = dic.get(s[r],0) +1
            r += 1
            while len(dic.keys())>2:
                dic[s[l]] -= 1
                if dic[s[l]] == 0:
                    del dic[s[l]]
                l += 1
            res = max(res, sum(dic.values()))
        return res