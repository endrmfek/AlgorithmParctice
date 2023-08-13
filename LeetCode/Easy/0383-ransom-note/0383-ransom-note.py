from collections import defaultdict
class Solution:
    def canConstruct(self, ransomNote: str, magazine: str) -> bool:
        maga = defaultdict(int)
        
        for char in magazine:
            maga[char] += 1
            
            
        for char in ransomNote:
            maga[char] -= 1
            
            if maga[char] == -1:
                return False
    
        return True