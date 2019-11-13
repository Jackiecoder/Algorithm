
from test_random import test_case


def countsort(ls):
    bucket = [0]*(max(ls)+1)
    for num in ls:
        bucket[num] += 1
    i = 0
    for j in range(len(bucket)):
        while bucket[j] > 0:
            ls[i] = j
            bucket[j] -= 1
            i += 1
    return ls


if __name__ == "__main__":
    testcase = test_case(20).shuffle()
    print(testcase)
    print(countsort(testcase))
