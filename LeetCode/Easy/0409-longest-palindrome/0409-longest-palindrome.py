from collections import Counter

class Solution:
    def longestPalindrome(self, s: str) -> int:
        #가장 긴거부터 검사를 해야겠죠
        #length == 7 이라면
        # for length in range(len(s), 0, -1):
        #     for idx in range(len(s)-length+1):
        #         if s[idx:idx+length] == s[idx:idx+length][::-1]:
        #             return length
        
        #-> 이 단어들로 만들수 있는 최대 palindrome 찾는거야.
        counter = Counter(s)
        answer = 0
        odd = False
        for value in counter.values():
            if value % 2 == 1:
                odd = True
            answer += (value // 2) * 2
            
        return answer+1 if odd else answer
                
                