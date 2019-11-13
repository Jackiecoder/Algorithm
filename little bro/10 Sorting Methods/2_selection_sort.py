from test_random import test_case


def selection_sort(ls):
    n = len(ls)
    for i in range(n):
        min_ind = i
        for j in range(i, n):
            if ls[min_ind] > ls[j]:
                min_ind = j
        ls[min_ind], ls[i] = ls[i], ls[min_ind]
    return ls


if __name__ == "__main__":
    testcase = test_case().shuffle()
    print(testcase)
    print(selection_sort(testcase))
