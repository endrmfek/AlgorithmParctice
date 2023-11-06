import sys
from itertools import combinations
input = sys.stdin.readline

while True:
  data = list(map(int,input().split()))

  if data[0] == 0:
    break;

  n = data[0]
  arr = data[1:]

  for result in combinations(arr, 6):
    print(*result)

  print()