class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return None
        if len(nums) == 1:
            return nums[0]
        if len(nums) == 2:
            return nums[0] if nums[0] < nums[1] else nums[1]
        l = 0
        r = len(nums)-1
        while l+1 < r:
            while nums[l+1] == nums[l] and l+1 < r:
                l += 1
            while nums[r-1] == nums[r] and l+1 < r:
                r -= 1
            mid = l+(r-l)//2
            lval = nums[l]
            rval = nums[r]
            mval = nums[mid]
            # print(l, r, mid)
            if lval < mval < rval:
                return lval
            elif mval > lval and mval > rval:
                l = mid
            elif mval < rval and mval < lval:
                r = mid
            else:
                break
        # print(l, r)
        return min(nums[l], nums[r])
