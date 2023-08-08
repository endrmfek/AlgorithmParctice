from collections import deque
class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        original = image[sr][sc]
        row = len(image)
        col = len(image[0])
        
        if original == color:
            return image
        
        q = deque([(sr,sc)])
        
        while q:
            nowRow, nowCol = q.popleft()
            image[nowRow][nowCol] = color
            
            for dr,dc in [(1,0),(-1,0),(0,1),(0,-1)]:
                nextRow, nextCol = nowRow+dr, nowCol+dc
                
                if 0<=nextRow < row and 0<=nextCol < col:
                    if image[nextRow][nextCol] == original:
                        q.append((nextRow, nextCol))
                    
        return image