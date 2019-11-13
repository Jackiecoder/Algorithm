from test_random import test_case


def insert_sort(ls):
    n = len(ls)
    for i in range(1, n):
        for j in range(i, 0, -1):
            if ls[j] < ls[j-1]:
                ls[j], ls[j-1] = ls[j-1], ls[j]
    return ls


if __name__ == "__main__":
    testcase = test_case().shuffle()
    print(testcase)
    print(insert_sort(testcase))
