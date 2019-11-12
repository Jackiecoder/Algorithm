# ascending bubble sort
import random


def bubblesort(ls):
    n = len(ls)
    for i in range(n):
        for j in range(i+1, n):
            if ls[i] > ls[j]:
                ls[i], ls[j] = ls[j], ls[i]
    return ls


if __name__ == "__main__":
    testcase = list(range(20))
    random.seed(123)
    random.shuffle(testcase)
    print("the inputs is ", testcase)
    res = bubblesort(testcase)
    print("The sorted list is :", res)
