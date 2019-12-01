class Solution:
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        '''
        DP
        subproblem: how many paths to grid[i,j]
        definition: DP[i,j] = n, means there are n paths from [0,0] to [i,j]
        expression: set obstacle to 0, else 1
                    DP[i,j] = DP[i-1,j]+DP[i,j-1], if DP[i,j]!= 0,
                    continue, else
        '''
        m = len(obstacleGrid)
        n = len(obstacleGrid[0])
        dp = [[0 for _ in range(n)] for _ in range(m)]
        for i in range(m):
            for j in range(n):
                dp[i][j] = 1 - obstacleGrid[i][j]
        flag = 1
        for i in range(m):
            if dp[i][0] == 0:
                flag = 0
            if not flag:
                dp[i][0] = 0
        flag = 1
        for j in range(n):
            if dp[0][j] == 0:
                flag = 0
            if not flag:
                dp[0][j] = 0
        for i in range(1, m):
            for j in range(1, n):
                if dp[i][j] == 0:
                    continue
                else:
                    dp[i][j] = dp[i-1][j]+dp[i][j-1]
        return dp[-1][-1]
