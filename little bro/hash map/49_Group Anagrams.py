class Solution(object):
    def groupAnagrams(self, strs):
        """
        :type strs: List[str]
        :rtype: List[List[str]]
        """
        # second time
        res = {}
        for s in strs:
            ana = str(sorted(s))
            res[ana] = res.get(ana, [])
            res[ana].append(s)
        return res.values()
  