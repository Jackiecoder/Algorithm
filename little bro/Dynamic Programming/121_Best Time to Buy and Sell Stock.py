class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        '''
        DP
        '''
        if not prices:
            return 0
        n = len(prices)
        dp = [0 for _ in range(n)]
        # dp means max profit in i th day
        # dp[i] = dp[i-1] if prices[i]<prices[i-1] else prices[i]-min_price
        min_price = prices[0]

        for i in range(1, n):
            dp[i] = dp[i-1] if prices[i] < prices[i-1] else prices[i]-min_price
            min_price = min(prices[i], min_price)
        return max(dp)
