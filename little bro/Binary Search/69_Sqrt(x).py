class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0 or x == 1:
            return x
        left = 0
        right = x
        while left+1 < right:
            mid = (left+right)//2
            sqrt = mid*mid
            if sqrt > x:
                right = mid
            elif sqrt < x:
                left = mid
            else:
                return mid
        return left
