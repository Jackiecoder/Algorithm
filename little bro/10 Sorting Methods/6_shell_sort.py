from test_random import test_case


def shellsort(nums):
    n = len(nums)
    gap = 1
    while gap < n // 3:
        gap = gap*3+1
    while gap > 0:
        for i in range(gap, n):
            curNum, preIndex = nums[i], i-gap
            while preIndex >= 0 and curNum < nums[preIndex]:
                nums[preIndex+gap] = nums[preIndex]
                preIndex -= gap
            nums[preIndex + gap] = curNum
        gap //= 3
    return nums


if __name__ == "__main__":
    testcase = test_case(20).shuffle()
    print(testcase)
    print(shellsort(testcase))
