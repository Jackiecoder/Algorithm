# ascending bubble sort
from test_random import test_case


def bubblesort(ls):
    n = len(ls)
    for i in range(n):
        for j in range(i+1, n):
            if ls[i] > ls[j]:
                ls[i], ls[j] = ls[j], ls[i]
    return ls


if __name__ == "__main__":
    testcase = test_case().shuffle()
    print(testcase)
    print(bubblesort(testcase))
