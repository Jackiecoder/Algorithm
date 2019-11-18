
class Solution:
    def firstBadVersion(self, n):
        """
        :type n: int
        :rtype: int
        """
        l = 0
        r = n
        while l+1 < r:
            mid = (l+r)//2
            bad = isBadVersion(mid)
            if bad:
                r = mid
            else:
                l = mid
        return r
