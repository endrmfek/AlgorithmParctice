import sys
input = sys.stdin.readline

n = int(input())
data = []
for i in range(n):
  data.append(list(map(int, input().split())))

data.sort(key=lambda x: (x[1], x[0]))

for d in data:
  print(d[0], d[1])