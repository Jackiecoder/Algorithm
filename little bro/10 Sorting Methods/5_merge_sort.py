# ascending bubble sort
from test_random import test_case


def mergesort(ls):
    def merge(l, r):
        res = []
        i = j = 0
        while i < len(l) and j < len(r):
            if l[i] <= r[j]:
                res.append(l[i])
                i += 1
            else:
                res.append(r[j])
                j += 1
        res = res + l[i:] + r[j:]
        return res
    if len(ls) <= 1:
        return ls
    mid = len(ls)//2
    l = mergesort(ls[:mid])
    r = mergesort(ls[mid:])
    res = merge(l, r)
    return res


if __name__ == "__main__":
    testcase = test_case(20).shuffle()
    print(testcase)
    print(mergesort(testcase))
