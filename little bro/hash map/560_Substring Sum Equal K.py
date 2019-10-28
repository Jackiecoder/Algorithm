class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        dic = {0:1}
        res = 0
        summ = 0
        for v in nums:
            summ += v
            res += dic.get(summ-k, 0)
            dic[summ] = dic.get(summ, 0) +1
        return res