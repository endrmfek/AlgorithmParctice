class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        #아주 간단하죠
        dp = [*nums]
        
        for i in range(1, len(nums)):
            dp[i] = max(dp[i], dp[i]+dp[i-1])
            
        return max(dp)
        