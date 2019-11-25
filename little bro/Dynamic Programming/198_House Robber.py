class Solution:
    def rob(self, nums: List[int]) -> int:
        # subproblem: How much money can I collect in first "i" houses.
        # definition: DP[i] means the maximum money I can collect in first "i" houses.
        # expression: dp[i] = max(dp[i-3],dp[i-2])+ nums[i]
        n = len(nums)
        if not nums:
            return 0
        elif n <= 2:
            return max(nums)
        dp = [0 for _ in range(n)]
        dp[0] = nums[0]
        dp[1] = nums[1]
        for i in range(2, n):
            dp[i] = max(dp[i-3], dp[i-2])+nums[i]
        return max(dp[-1], dp[-2])
