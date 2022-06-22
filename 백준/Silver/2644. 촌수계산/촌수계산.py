from collections import deque

def dfs(start):
  q = deque()
  q.append(start)
  dist[start] = 0

  while q:
    s = q.popleft()

    for node, dst in graph[s]:
      if dist[node] == -1:
        q.append(node)
        dist[node] = dist[s] + 1



n = int(input())
start , end = map(int, input().split())
m = int(input())

graph = [[] for _ in range(n+1)]
dist = [-1] * (n+1)

for _ in range(m):
  a , b = map(int, input().split())
  graph[a].append((b,1)) # 거리는 저장해야지 아마?..
  graph[b].append((a,1)) # 양방향으로 두고

# print(graph)
dfs(start)

print(dist[end])

