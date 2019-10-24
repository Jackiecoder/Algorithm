class Solution(object):
    def findKthLargest(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        '''
        min heap
        '''
        res = []
        for i in nums:
            if len(res) < k:
                heapq.heappush(res, i)
            else:
                if i > res[0]:
                    heapq.heapreplace(res, i)
        return res[0]