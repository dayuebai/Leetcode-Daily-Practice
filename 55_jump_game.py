class Solution(object):
    def canJump(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        size = len(nums)
        max_i = 0
        
        for i in range(size):
            if max_i < i or max_i >= size - 1:
                break
            max_i = max(max_i, i + nums[i])
        return max_i >= size - 1
        
