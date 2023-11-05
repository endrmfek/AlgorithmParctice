import sys
input = sys.stdin.readline

n = int(input())
arr = set(map(int, input().split()))

arr = sorted(list(arr))

for num in arr:
  print(num, end=' ')