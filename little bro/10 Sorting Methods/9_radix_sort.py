from test_random import test_case


def radixsort(nums):
    mod = 10
    div = 1
    mostBit = len(str(max(nums)))
    buckets = [[]for row in range(mod)]
    while mostBit:
        for num in nums:
            buckets[num//div % mod].append(num)
        i = 0
        for bucket in buckets:
            while bucket:
                nums[i] = bucket.pop(0)
                i += 1
        div *= 10
        mostBit -= 1
    return nums


if __name__ == "__main__":
    testcase = test_case(20).shuffle()
    print(testcase)
    print(radixsort(testcase))
