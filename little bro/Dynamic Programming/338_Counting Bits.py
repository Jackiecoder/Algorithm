class Solution:
    def countBits(self, num: int) -> List[int]:
        '''
        DP
        subproblem: number i/2 have n of "1" in binary representation.
        definition: DP[i] = n, means there are n of "1" for number i
        expression: if i%2 == 0: DP[i] == DP[i/2]
                    else: DP[i] == DP[i-1]
        '''
        dp = [0 for i in range(num+1)]
        dp[0] = 0
        for i in range(num+1):
            if i % 2 == 0:
                dp[i] = dp[i//2]
            else:
                dp[i] = 1+dp[i-1]
        return dp
