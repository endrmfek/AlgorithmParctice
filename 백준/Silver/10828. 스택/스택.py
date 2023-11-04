import sys
n = int(sys.stdin.readline())
arr = []

for _ in range(n):
  data = sys.stdin.readline().split()

  if data[0] == 'push':
    arr.append(data[1])
  if data[0] == 'pop':
    if arr:
      print(arr.pop())
    else:
      print(-1)
  if data[0] == 'size':
    print(len(arr))
  if data[0] == 'empty':
    if arr:
      print(0)
    else:
      print(1)
  if data[0] == 'top':
    if arr:
      print(arr[-1])
    else:
      print(-1)
    
  