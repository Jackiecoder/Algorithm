class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        '''
        DP
        '''
        if not nums:
            return
        # dp[i] means maximum sum of first i elements.
        n = len(nums)
        dp = [0 for _ in range(n)]
        dp[0] = nums[0]
        for i in range(1, n):
            dp[i] = dp[i-1]+nums[i] if dp[i-1] > 0 else nums[i]
        return max(dp)
