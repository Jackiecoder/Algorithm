def kWeakestRows(mat, k):
    ls = []
    for i in range(len(mat)):
        ls.append([i, mat[i].count(1)])
    sorted_ls = sorted(ls, key=lambda x: x[1])
    return [x[0] for x in sorted_ls[0:k]]


mat = [[1, 1, 0, 0, 0],
       [1, 1, 1, 1, 0],
       [1, 0, 0, 0, 0],
       [1, 1, 0, 0, 0],
       [1, 1, 1, 1, 1]]
print(kWeakestRows(mat, 3))
