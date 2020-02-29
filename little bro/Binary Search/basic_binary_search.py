import random


def bs(ls, target):
    l = 0
    r = len(ls)
    while l < r:
        mid = (l+r)//2
        val = ls[mid]
        if val < target:
            l = mid+1
        elif val > target:
            r = mid
        else:
            return mid


def bs_rec(ls, target, l, r):
    if l >= r:
        return None
    mid = (l+r)//2
    val = ls[mid]
    if val < target:
        bs_rec(ls, target, mid+1, r)
    elif val > target:
        bs_rec(ls, target, l, mid)
    else:
        return mid


testcase = list(range(20, 50))
target = 55
print(testcase)
print("target = ", target)
print(bs(testcase, target))
print(bs_rec(testcase, target, 0, len(testcase)))
