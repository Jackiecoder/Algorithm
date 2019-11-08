class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        maxleng = 0
        cur = 0
        dic = {0:-1}
        for i in range(len(nums)):
            cur += 1 if nums[i] else -1
            dic[cur] = dic.get(cur, i)
            maxleng = max(maxleng, i-dic[cur])
        return maxleng