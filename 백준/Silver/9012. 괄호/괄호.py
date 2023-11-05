import sys
from collections import defaultdict
input = sys.stdin.readline
n = int(input())

def check(data):
  stack = []
  for c in data:
    if c == '(':
      stack.append(c)
    elif c == ')':
      if len(stack) == 0:
        return False
      stack.pop()
  return len(stack) == 0

for _ in range(n):
  data = input().strip()
  if check(data):
    print('YES')
  else:
    print('NO')
