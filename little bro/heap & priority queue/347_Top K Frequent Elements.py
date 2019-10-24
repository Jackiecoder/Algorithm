class Solution(object):
    def topKFrequent(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: List[int]
        """
        
        val_fre = {}
        for i in nums:
            val_fre[i] = val_fre.get(i, 0) + 1
        res = []
        for key in val_fre:
            if len(res) < k:
                heapq.heappush(res, [val_fre[key], key])
            else:
                if val_fre[key] > res[0][0]:
                    heapq.heapreplace(res, [val_fre[key], key])
        return [x[1] for x in res]
        
      