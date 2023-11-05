import sys
from collections import defaultdict
input = sys.stdin.readline

n = int(input())
data = defaultdict(int)

arr_a = list(map(int, input().split()))

for num in arr_a:
  data[num] += 1

m = int(input())
arr_b = list(map(int, input().split()))

result = []

for num in arr_b:
  if num in data:
    print(data[num], end=' ')
  else:
    print(0, end=' ')

  