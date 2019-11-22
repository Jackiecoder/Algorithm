class Solution:
    def longestPalindrome(self, s: str) -> str:
        '''
        DP 
        '''
        n = len(s)
        dp = [[False for _ in range(n)] for _ in range(n)]
        # dp[a,b] means substring between index a and b are Palindromic or not.
        # The subproblem is -- if dp[a+1][b-1] is Palindromic
        res = ""
        for i in range(n-1, -1, -1):
            for j in range(i, n):
                dp[i][j] = s[i] == s[j] and (i+3 > j or dp[i+1][j-1])
                if dp[i][j] and j-i+1 > len(res):
                    res = s[i:j+1]
        return res
