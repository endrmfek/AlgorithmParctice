n = int(input())
data = list(map(int,input().split()))

data.sort()

sum1 = 0
sum2 = 0
for i in data:
  sum1 = sum1 + i
  sum2 = sum2 + sum1

print(sum2)