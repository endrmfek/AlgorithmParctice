import sys
from collections import deque

n = int(sys.stdin.readline())
arr = deque()

for _ in range(n):
  data = list(sys.stdin.readline().split())

  if data[0] == 'push':
    arr.append(data[1])
  if data[0] == 'pop':
    if arr:
      print(arr.popleft())
    else:
      print(-1)
  if data[0] == 'size':
    print(len(arr))
  if data[0] == 'empty':
    if arr:
      print(0)
    else:
      print(1)
  if data[0] == 'front':
    if arr:
      print(arr[0])
    else:
      print(-1)
  if data[0] == 'back':
    if arr:
      print(arr[-1])
    else:
      print(-1)
    
  