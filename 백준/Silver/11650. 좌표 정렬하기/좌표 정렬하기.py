import sys

n = int(sys.stdin.readline())
data = []
for i in range(n):
  data.append(list(map(int, sys.stdin.readline().split())))

data.sort(key=lambda x: (x[0], x[1]))

for d in data:
  print(d[0], d[1])