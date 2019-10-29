class Solution(object):
    def isIsomorphic(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        # second time
        if len(s) != len(t):
            return False
        dic1 = {}
        dic2 = {}
        for i in range(len(s)):
            dic1[s[i]] = dic1.get(s[i], [])
            dic1[s[i]].append(i)
        for i in range(len(t)):
            dic2[t[i]] = dic2.get(t[i], [])
            dic2[t[i]].append(i)
        for val in dic1.values():
            if val not in dic2.values():
                return False
        return True
        