class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #중복 character가 없는 가장 긴 substring
        #슬라이딩 윈도우.
        
        data = {}
        left = 0
        length = 0
        
        for right, char in enumerate(s):
            
            if char in data and data[char] >= left:
                left = data[char] + 1
            else:
                length = max(length, right-left+1)    
                
            data[char] = right
            
            
        return length