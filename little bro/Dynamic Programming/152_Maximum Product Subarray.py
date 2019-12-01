class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        '''
        DP
        '''
        n = len(nums)
        if n == 1:
            return nums[0]
        dp_max = [0 for _ in range(n+1)]
        dp_min = [0 for _ in range(n+1)]
        for i in range(1, n+1):
            if nums[i-1] > 0:
                dp_max[i] = max(dp_max[i-1]*nums[i-1], nums[i-1])
                dp_min[i] = min(dp_min[i-1]*nums[i-1], nums[i-1])
            else:
                dp_max[i] = max(dp_min[i-1]*nums[i-1], nums[i-1])
                dp_min[i] = min(dp_max[i-1]*nums[i-1], nums[i-1])
        return max(dp_max)
