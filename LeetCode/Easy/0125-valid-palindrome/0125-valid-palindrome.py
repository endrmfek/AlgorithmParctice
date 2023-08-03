class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        
        data = [i for i in s if i.isalnum()]
        data = ''.join(data).lower()
       
        print(data)
        return data == data[::-1]
        
        
            
