n, m = map(int,input().split())
graph = [[] for _ in range(n+1)]
visited = [0] * (n+1)

def dfs(start):
  if visited[start]: # 종료조건이 맨 처음 나와야돼.
    return

  visited[start] = True
  for i in graph[start]:
    if not visited[i]:
      dfs(i)
      


for i in range(m):
  a , b = map(int,input().split())
  graph[a].append(b)
  graph[b].append(a) # 방향이 없응게?

count = 0
for i in range(1, n+1):
  if not visited[i]:
    dfs(i)
    count+=1

print(count)



