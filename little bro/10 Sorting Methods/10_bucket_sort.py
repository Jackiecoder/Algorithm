from test_random import test_case


def bucketsort(nums, bucketSize=5):
    maxVal, minVal = max(nums), min(nums)
    bucketCount = (maxVal - minVal) // bucketSize+1
    buckets = []
    for i in range(bucketCount):
        buckets.append([])
    for num in nums:
        buckets[(num-minVal)//bucketSize].append(num)
    nums.clear()
    for bucket in buckets:
        insert_sort(bucket)
        nums.extend(bucket)

    return nums


def insert_sort(ls):
    n = len(ls)
    for i in range(1, n):
        for j in range(i, 0, -1):
            if ls[j] < ls[j-1]:
                ls[j], ls[j-1] = ls[j-1], ls[j]
    return ls


if __name__ == "__main__":
    testcase = test_case(20).shuffle()
    print(testcase)
    print(bucketsort(testcase))
