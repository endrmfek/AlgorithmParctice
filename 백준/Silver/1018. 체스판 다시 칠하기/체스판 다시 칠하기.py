n ,m = map(int,input().split())

data = []
count = []

for _ in range(n):
  data.append(input())

for i in range(n-7):
  for j in range(m-7):
    one = 0
    two = 0

    for a in range(i , i+8):
      for b in range(j , j+8):
        if (a+b) % 2 == 0:
          if data[a][b] != 'W': one +=1
          if data[a][b] != 'B': two +=1
        else:
          if data[a][b] != 'B': one += 1
          if data[a][b] != 'W': two += 1
    count.append(min(one,two))

print(min(count))
