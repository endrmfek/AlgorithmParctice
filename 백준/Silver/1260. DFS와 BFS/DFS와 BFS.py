from collections import deque


n , m , start = map(int,input().split())
graph = [[] for i in range(n+1)]
visited_d = [0] * (n+1)
visited_b = [0] * (n+1)

for i in range(m):
  a ,b = map(int,input().split())
  graph[a].append(b)
  graph[b].append(a)

for i in range(1,n+1):
  graph[i].sort()

def dfs(start):
  visited_d[start] = True
  print(start , end=' ')

  for i in graph[start]:
    if not visited_d[i]:
      dfs(i)

def bfs(start):
  q = deque([start])
  visited_b[start] = True

  while q:
    now = q.popleft()  
    print(now, end=' ')

    for i in graph[now]:
      if not visited_b[i]:
        q.append(i)
        visited_b[i] = True

dfs(start)
print()
bfs(start)

