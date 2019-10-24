class Solution(object):
    def kSmallestPairs(self, nums1, nums2, k):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :type k: int
        :rtype: List[List[int]]
        """
        
        '''
        max heap
        '''
        res = []
        for j in nums2:
            for i in nums1:
                val = -(i+j)   # all value are saved in negative way.
                if len(res) == k:
                    if val > res[0][0]:
                        heapq.heapreplace(res, [val,[i,j]])
                else:
                    heapq.heappush(res, [-(i+j),[i,j]])
                # print(val, res)
        return [x[1] for x in res]