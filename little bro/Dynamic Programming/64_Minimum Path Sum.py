class Solution(object):
    def __init__(self, grid):
        self.grid = grid

    def minPathSum_original(self):
        grid = self.grid
        '''
        DP: original
        '''
        m = len(grid)
        n = len(grid[0])
        if not m or not n:
            return 0
        dp = [[0 for _ in range(n)] for _ in range(m)]
        temp = 0
        for i in range(m):
            temp += grid[i][0]
            dp[i][0] = temp
        temp = 0
        for j in range(n):
            temp += grid[0][j]
            dp[0][j] = temp
        for i in range(1, m):
            for j in range(1, n):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1])+grid[i][j]
        return dp[-1][-1]

    '''
    Follow up 1: use 1 dimension dp 
    '''

    '''
    Follow up 2 : print path
    '''


if __name__ == "__main__":
    tc = [[1, 3, 1], [1, 5, 1], [4, 2, 1]]
    res_1 = Solution(tc).minPathSum_original()
    res_2 = Solution(tc).minPathSum_followup1()
    print(res_1, res_2)
