class Solution:
    def kthSmallest(self, matrix: List[List[int]], k: int) -> int:
        # binary search
        n = len(matrix)
        if n == 1:
            return matrix[0][0]
        l, r = matrix[0][0]-1, matrix[n-1][n-1]+1
        while l+1 < r:
            mid = l+(r-l)//2
            count, most = self.countNo(mid, matrix, n)
            if count < k:
                l = mid
            elif count > k:
                r = mid
            else:
                return most
        if count != k:
            count, most = self.countNo(l, matrix, n)
        if count != k:
            count, most = self.countNo(r, matrix, n)
        return most
