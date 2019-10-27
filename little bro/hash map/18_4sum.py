class Solution(object):
    def fourSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        nums.sort()
        res = []

        for i in range(len(nums)-3):
            if i>0 and nums[i] == nums[i-1]:
                continue            
            for j in range(i+1, len(nums)-2): 
                if (j>i+1 and nums[j] == nums[j-1]):
                    continue
                l = j+1
                r = len(nums)-1
                
                while l<r:
                    if ( l-1 != j) and nums[l]== nums[l-1]:
                        l += 1
                        continue
                    if ( r+1 != len(nums) and nums[r] == nums):
                        r -= 1
                        continue
                    temp_sum = nums[i]+nums[j]+nums[l]+nums[r]
                    if temp_sum > target:
                        r -= 1
                    elif temp_sum < target:
                        l += 1
                    else:
                        res.append([nums[i],nums[j],nums[l],nums[r]])
                        l += 1
                        r -= 1
        return res