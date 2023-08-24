class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        #중복 결과가 있으면 안됨.
        #ex) [-1,0,1] , [0,-1,1]은 같은 결과이다.
        
        nums.sort()
        res = []
        
        for i, v in enumerate(nums):
            
            if v > 0:
                break
            
            if i > 0 and v == nums[i-1]:
                continue
            
            left, right = i+1, len(nums)-1
            
            while left < right:
                hap = v + nums[left] + nums[right]
                
                if hap > 0:
                    right -= 1
                elif hap < 0:
                    left += 1
                else:
                    res.append([v, nums[left], nums[right]])
                    left += 1
                    while nums[left-1] == nums[left] and left < right:
                        left += 1
        
        return res
            