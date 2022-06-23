#F S G U D
#꼭대기 F , 스타트 S , 목적지 G , 위로 U, 아래로 D

from collections import deque


F,S,G,U,D = map(int,input().split())
INF = int(1e9)
floor = [INF] * (F+1)
q = deque()
q.append(S)
floor[S] = 0

while q:
  start = q.popleft()

  next_step = start + U
  prev_step = start - D

  if 1 <= next_step <=F and floor[next_step] == INF:
    floor[next_step] = min(floor[next_step], floor[start]+1)
    q.append(next_step)
  
  if 1<= prev_step <= F and floor[prev_step] == INF:
    floor[prev_step] = min(floor[prev_step], floor[start]+1)
    q.append(prev_step)

if floor[G] != INF:
  print(floor[G])
else:
  print("use the stairs")