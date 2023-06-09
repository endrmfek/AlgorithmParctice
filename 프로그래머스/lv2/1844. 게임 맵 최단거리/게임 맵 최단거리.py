#1,1 -> n,m
from collections import deque
def solution(maps):
    answer = 0
    row = len(maps)
    col = len(maps[0])
    q = deque()
    q.append((0,0,1))
    visited = set()
    
    while q:
        x,y,cnt = q.popleft()
        
        if x == row-1 and y == col-1:
            return cnt
        
        for dx, dy in ((0,1), (0,-1), (1,0), (-1,0)):
            nx = x+dx
            ny = y+dy
            if 0<= nx < row and 0<=ny<col and maps[nx][ny] == 1:
                if (nx,ny) not in visited:
                    visited.add((nx,ny))
                    q.append((nx,ny,cnt+1))
    return -1