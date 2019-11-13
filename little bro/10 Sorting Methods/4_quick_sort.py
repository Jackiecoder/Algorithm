from test_random import test_case


def quicksort(ls):
    def partition(ls, l, r):
        if l >= r:
            return
        target = ls[l]
        templ = l+1
        tempr = r
        while templ < tempr:
            while ls[templ] <= target and templ < r:
                templ += 1
            while ls[tempr] >= target and tempr > l:
                tempr -= 1
            if templ < tempr:
                ls[templ], ls[tempr] = ls[tempr], ls[templ]
        print(templ, tempr)
        cur = tempr
        ls[l], ls[cur] = ls[cur], ls[l]
        print(l, cur, "("+str(target)+")", r, ls)
        partition(ls, l, cur-1)
        partition(ls, cur+1, r)
    partition(ls, 0, len(ls)-1)


if __name__ == "__main__":
    testcase = test_case(20).shuffle()
    print(testcase)
    quicksort(testcase)
    print(testcase)
