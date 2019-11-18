class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix or not matrix[0]:
            return False
        m, n = len(matrix), len(matrix[0])
        for row in range(m):
            if matrix[row][0] > target:
                return False
            elif matrix[row][0] == target:
                return True
            l, r = 0, n
            while l+1 < r:
                mid = l+(r-l)//2
                val = matrix[row][mid]
                if val < target:
                    l = mid
                elif val > target:
                    r = mid
                else:
                    return True
        return False
