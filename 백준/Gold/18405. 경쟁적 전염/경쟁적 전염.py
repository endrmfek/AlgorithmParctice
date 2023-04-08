from collections import deque

n , k = map(int,input().split()) # 크기 , 바이러스 종류

data = []
graph = []

for i in range(n):
    graph.append(list(map(int, input().split())))
    for j in range(n):
        graph[i][j] != 0
        data.append((graph[i][j] , 0, i, j))

data.sort()
q = deque(data)
dx = [0,1,0,-1]
dy = [1,0,-1,0]

target_s , target_x, target_y = map(int,input().split())

while q:
    target, s , x, y = q.popleft()

    if target_s == s:
        break;

    for i in range(4):
        nx = x + dx[i]
        ny = y+ dy[i]

        if 0<= nx <n and 0<= ny <n:
            if graph[nx][ny] == 0:
                graph[nx][ny] = target
                q.append((target, s+1, nx, ny))

print(graph[target_x-1][target_y-1])

    

