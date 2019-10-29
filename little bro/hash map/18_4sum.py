class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        # third time
        if len(nums)<4:
            return []
        nums.sort()
        res = []
        def NSum(ls, remain, N, temp_res, res):
            if N > 2:
                for i in range(len(ls)):
                    if i > 0 and ls[i] == ls[i-1]:
                        continue
                    NSum(ls[i+1:], remain-ls[i], N-1, temp_res+[ls[i]], res)
            else:
                l,r = 0, len(ls)-1
                while l<r:
                    add = ls[l] + ls[r]
                    if add < remain:
                        l += 1
                    elif add > remain:
                        r -= 1
                    else:
                        res.append(temp_res+[ls[l],ls[r]])
                        l += 1
                        r -= 1
                        while l<r and ls[l] == ls[l-1]:
                            l += 1
                        while l<r and ls[r] == ls[r+1]:
                            r -= 1
        NSum(nums, target, 4, [], res)
        return res
        