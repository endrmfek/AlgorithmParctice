import sys
from collections import deque
input = sys.stdin.readline

n, k = map(int, input().split())

data = [i for i in range(1,n+1)]
q = deque(data)
answer = []

while q:
  for _ in range(k-1):
    q.append(q.popleft())
  answer.append(q.popleft())
  
print(str(answer).replace('[','<').replace(']','>'))
