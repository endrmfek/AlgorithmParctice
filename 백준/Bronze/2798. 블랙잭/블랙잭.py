from itertools import combinations

n , m = map(int,input().split())

data = list(map(int,input().split()))

max = list(combinations(data,3))

x= []
for i in max:
  x.append(sum(i)) 

result = 0
for i in x:
  if i>result and i<=m:
    result = i

print(result)