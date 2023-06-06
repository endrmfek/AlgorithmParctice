import sys
sys.setrecursionlimit(int(1e9))

def solution(maps):
  answer = []
  visited = [[0] * len(maps[0]) for _ in range(len(maps))]

  def dfs(x,y,visited):
    cnt = 0
    if 0 <= x < len(maps) and 0 <= y < len(maps[0]):
      if not visited[x][y] and maps[x][y] != 'X' :
        visited[x][y] = True
        R = dfs(x,y+1, visited)
        L = dfs(x,y-1, visited)
        D = dfs(x+1,y, visited)
        U = dfs(x-1,y, visited)
        
        return int(maps[x][y]) + R + L + D + U
      else:
        return 0
    return 0
    
  for x, row in enumerate(maps):
    for y, col in enumerate(row):
      result = dfs(x,y,visited)
      if(result):
        answer.append(result)

  return sorted(answer) if len(answer) != 0 else [-1]
