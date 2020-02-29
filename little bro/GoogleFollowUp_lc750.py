
'''
Given a grid where each entry is only 0 or 1, find the number of corner rectangles.

A corner rectangle is 4 distinct 1s on the grid that form an axis-aligned rectangle. Note that only the corners need to have the value 1. Also, all four 1s used must be distinct.
'''


def func(grid):
    n, m = len(grid), len(grid[0])
    dic_ind = {}
    dic_val = {}
    for i in range(n):
        dic_ind[i] = {}
        for j in range(m):
            value = grid[i][j]
            dic_ind[i][value] = dic_ind[i].get(value, [])+[j]
            # dic[i][j] means in i th row, value j's index
            dic_val[i] = dic_val.get(i, [])+[value]
    res = 0
    for i in range(n):
        values_ith_row = set(dic_val[i])
        for j in range(i+1, m):
            values_jth_row = set(dic_val[j])
            same_value = values_ith_row & values_jth_row
            for v in same_value:
                index_ith_row = set(dic_ind[i][v])
                index_jth_row = set(dic_ind[j][v])
                same_index = index_ith_row & index_jth_row
                if len(same_index) >= 2:
                    res += len(same_index)*(len(same_index)-1)//2
    return res


A = [
    [7, 9, 6, 1, 7],
    [8, 1, 0, 2, 1],
    [7, 0, 1, 0, 7],
    [1, 1, 6, 1, 1],
    [5, 2, 9, 7, 1]
]
print(func(A))
