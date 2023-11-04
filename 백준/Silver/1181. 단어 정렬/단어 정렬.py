import sys

n = int(sys.stdin.readline())
data = set()
for i in range(n):
  data.add(sys.stdin.readline().strip())

data = list(data)

data.sort(key=lambda x: (len(x), x))

for d in data:
  print(d)