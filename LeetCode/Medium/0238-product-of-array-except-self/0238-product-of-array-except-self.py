class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        
#       You must write an algorithm that runs in O(n) time and without using the division operation.


        #1. 나누기가 가능하다면
        #2. n^2로 가능하다면.
        #3. dp
        #3-1 메모리를 많이쓰는 dp
        #3-2 메모리 최적화 dp
        
        #3-1
        n = len(nums)
        leftDp = [1]*n
        rightDp = [1]*n
        
        
        for i in range(1, n):
            leftDp[i] = leftDp[i-1]*nums[i-1]
        
        for i in range(n-2,-1,-1):
            rightDp[i] = rightDp[i+1]*nums[i+1]
            
        for i in range(n):
            rightDp[i] = rightDp[i] * leftDp[i]
            
        return rightDp