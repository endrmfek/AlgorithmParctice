#최소 신장 트리 -> 크루스칼 알고리즘.

import heapq
from math import sqrt
import sys
input = sys.stdin.readline

def find(parent, x):
  if parent[x] != x:
    parent[x] = find(parent, parent[x])
  return parent[x]

def union(parent, x, y):
  x = find(parent, x)
  y = find(parent, y)

  if x==y:
    return False
  else:
      parent[x] = y
      return True

n, C = map(int,input().split())
nodes = []
for i in range(n):
  nodes.append(list(map(int,input().split())))

parent = [i for i in range(n+1)]
pq = []

for i in range(n):
  for j in range(i+1 , n):
    a,b = nodes[i]
    c,d = nodes[j]
    cost = abs(a-c)**2 + abs(b-d)**2
    
    if cost >= C: 
      heapq.heappush(pq, [cost, i,j])

total = 0
edge_num = 0

while pq:
  now_cost , node1, node2 = heapq.heappop(pq)

  if union(parent, node1, node2):
    total += now_cost
    # print(total)
    edge_num += 1
    
    if edge_num == n-1: break;

if edge_num == n-1:
  print(total)
else:
  print(-1)