# n*m , m*k일때 곱하는 프로그램.

n, m = map(int,input().split())

matrix1 = [[*map(int,input().split())] for _ in range(n)]

m , k = map(int, input().split())

matrix2 = [[*map(int,input().split())] for _ in range(m)]

result = [[0]*k for _ in range(n)]

for row in range(n):
  for col in range(k):
    e = 0
    for i in range(m):
      e += matrix1[row][i] * matrix2[i][col]
    result[row][col] = e

for r in result:
  print(*r)