class Solution(object):
    def sortArray(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        
        '''
        heap sort
        '''
        heapq.heapify(nums)
        res = []
        while nums:
            res.append(heapq.heappop(nums))
        return res