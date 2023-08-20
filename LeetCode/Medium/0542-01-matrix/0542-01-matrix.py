from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        #Bfs로 그냥 풀면돼.
        q = deque()
        n = len(mat)
        m = len(mat[0])
        
        for i in range(n):
            for j in range(m):
                if mat[i][j] == 0:
                    q.append((i,j))
                else:
                    mat[i][j] = -1
                    
        while q:
            nowRow, nowCol = q.popleft()
            
            for nextRow, nextCol in [(nowRow+1,nowCol),(nowRow,nowCol+1),(nowRow-1,nowCol),(nowRow,nowCol-1)]:
                if 0<=nextRow<n and 0<=nextCol<m and mat[nextRow][nextCol] == -1:
                    mat[nextRow][nextCol] = mat[nowRow][nowCol] + 1
                    q.append((nextRow,nextCol))
                    
        return mat
                    
        