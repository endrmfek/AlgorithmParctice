from collections import deque

def solution(x, y, n):
    visited = [0] * 10000001
    
    q = deque()
    q.append((x,0))
    visited[x] = 1
    
    while q:
        num, count = q.popleft()
        if(num == y):
            return count
        for next in (num+n, num*2, num*3):
            if not visited[next] and next <= y:
                visited[next] = 1
                q.append((next, count+1))
                
    return -1