#두가지로 가능할껄? DFS, permutation
from itertools import permutations

def solution(k, dungeons):
    answer = -1
    visited = [False] * len(dungeons)
    
    def dfs(depth, fatigue, dungeons):
        nonlocal answer
        for i in range(len(visited)):
            if not visited[i] and fatigue >= dungeons[i][0]:
                visited[i] = True
                dfs(depth+1, fatigue-dungeons[i][1], dungeons)
                visited[i] = False
            answer = max(depth , answer)
            
        
            
    dfs(0,k,dungeons)
    
    return answer