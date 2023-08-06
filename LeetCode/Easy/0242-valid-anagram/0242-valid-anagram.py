from collections import defaultdict
class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        
        if len(s) != len(t):
            return False
        
        dic = defaultdict(int)
        
        for schar in s:
            dic[schar] += 1
            
        for tchar in t:
            dic[tchar] -= 1
            
            if dic[tchar] == -1:
                return False
        
        return True
        