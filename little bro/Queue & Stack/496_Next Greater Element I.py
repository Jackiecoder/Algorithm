class Solution(object):
    def nextGreaterElement(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: List[int]
        """
        dic = {}
        stack = []
        for num in nums2:
            while len(stack) and stack[-1]< num:
                dic[stack.pop()] = num
            stack.append(num)
        return [dic.get(num, -1) for num in nums1]