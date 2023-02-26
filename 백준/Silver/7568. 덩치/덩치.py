n = int(input())
std = []

for _ in range(n):
  a , b = map(int,input().split())
  std.append((a,b))

for i in std:
  rank = 1
  
  for j in std:
    if i[0] < j[0] and i[1] < j[1]:
      rank += 1

  print(rank)