import sys
from collections import deque
input = sys.stdin.readline

tc = int(input())

for _ in range(tc):
  func = input().strip()
  num = int(input())
  q = deque(input().strip().replace('[','').replace(']','').split(','))

  if num == 0:
    q = deque()
    
  flag = 1
  reverse = 0
  for cmd in func:
    if cmd == 'R':
      reverse += 1
    if cmd == 'D':
      if len(q) < 1:
        print('error')
        flag = 0
        break
      else:
        if reverse % 2 == 0:
          q.popleft()
        else:
          q.pop()

  if flag == 0:
    continue
  else:
    if reverse % 2 == 0:
      print('[' + ','.join(q) + ']')
    else:
      q.reverse()
      print('[' + ','.join(q) + ']')