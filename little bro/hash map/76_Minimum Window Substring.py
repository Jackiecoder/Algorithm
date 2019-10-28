class Solution(object):
    def minWindow(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: str
        """
        if len(t)>len(s):
            return ''
        l = 0
        res = s+'t'
        dic = {}
        target_dic = {}
        for i in t:
            target_dic[i] = target_dic.get(i,0)+1
        for r in range(len(s)):
            dic[s[r]] = dic.get(s[r],0)+1
            while all((k in dic and dic[k]>=v) for k,v in target_dic.iteritems()):
                res = res if len(res) < r-l+1 else s[l:r+1]
                dic[s[l]] = dic.get(s[l]) -1
                l += 1
        return res if len(res)<=len(s) else ''