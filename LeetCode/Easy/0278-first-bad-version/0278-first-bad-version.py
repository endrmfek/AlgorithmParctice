# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        
        #이진탐색으로 찾아야겠다. 그치?
        left = 1
        right = n
        data = []
        while left <= right:
            mid = (left + right) // 2
            
            if isBadVersion(mid):
                data.append(mid)
                right = mid - 1
            else:
                left = mid + 1
        
        return min(data)