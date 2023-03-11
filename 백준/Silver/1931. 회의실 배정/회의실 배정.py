# 11
# 1 4
# 3 5
# 0 6
# 5 7
# 3 8
# 5 9
# 6 10
# 8 11
# 8 12
# 2 13
# 12 14

n = int(input())
data = []

for i in range(n):
  s, e = map(int,input().split())
  data.append([s,e])

data.sort(key=lambda x:(x[1], x[0]))

count = 1

end = data[0][1]
for i in range(1, len(data)):
  if data[i][0] >= end :
    end = data[i][1]
    count = count + 1
  
print(count)

