'''
어떤 나라에는 1~N번 까지의 도시와 M개의 단방향 도로가 존재한다. 모든 도로의 거리는 1
이때 특정한 도시 X로부터 출발하여 도달할 수 있는 모든 도시 중에서 '최단' 거리가 정확히 K
인 모든 도시의 번호를 출력하는 프로그램. X에서 X로 가는 최단 거리는 무적권 0이다

'''
from collections import deque
import sys

input = sys.stdin.readline
n, m, k, x = map(int,input().split())

data = [[] for _ in range(n+1)]

for _ in range(m):
    a, b = map(int,input().split())
    data[a].append(b)

distance = [-1] * (n+1)
distance[x] = 0

q = deque([x])

while q:
    now = q.popleft()

    for next in data[now]:
        if distance[next] == -1:
            distance[next] = distance[now] + 1
            q.append(next)

check = False
for i in range(n+1):
    if distance[i] == k:
        print(i)
        check = True

if k not in distance:
    print(-1)
        


