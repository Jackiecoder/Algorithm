class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if len(s)<=10:
            return []
        dic = {}
        for i in range(len(s)):
            seq = s[i:i+10]
            dic[seq] = dic.get(seq, 0)+1
        return [x for x in dic.keys() if dic[x]>1]