class Solution(object):
    def kClosest(self, points, K):
        """
        :type points: List[List[int]]
        :type K: int
        :rtype: List[List[int]]
        """
        '''
        max heap
        '''
        if K >= len(points):
            return points
        res = []
        for i in points:
            if len(res) < K:
                heapq.heappush(res, [-math.sqrt(i[0]**2+i[1]**2),i])
                continue
            else:
                dis = -math.sqrt(i[0]**2+i[1]**2)
                if dis > res[0][0]:
                    heapq.heapreplace(res, [dis, i])
        return [x[1] for x in res]