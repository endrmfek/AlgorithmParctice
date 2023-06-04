
def solution(maps):
  answer = 0
  for x, row in enumerate(maps):
    for y, col in enumerate(row):
      if maps[x][y] == 'S':
        sx, sy = x, y
      if maps[x][y] == 'E':
        ex, ey = x, y
      if maps[x][y] == 'L':
        lx, ly = x, y

  def bfs(x,y, end):
    q = []
    q.append((x,y,0))
    visited = set()
    visited.add((x,y))
  
    while q:
      x, y, length = q.pop(0)
      
      if maps[x][y] == end:
        return length

      for dx, dy in ((0,1), (0,-1), (1,0), (-1,0)):
        
        nx = x + dx
        ny = y + dy
        if 0 <= nx < len(maps) and 0 <= ny < len(maps[0]):
          if (nx, ny) not in visited:
            if maps[nx][ny] != 'X':
              q.append((nx,ny, length+1))
              visited.add((nx,ny))

    return None
  cnt = bfs(sx,sy,'L')
  if cnt == None:
    return -1
  answer += cnt
  cnt = bfs(lx,ly,'E')
  if cnt == None:
    return -1
  answer += cnt
  return answer
  
  
