#n*n따리 행렬 a의 b제곱을 구해봐라.
#각 행렬의 원소는 1000으로 나눠라.

n, B = map(int,input().split())
A = [[*map(int,input().split())] for _ in range(n)]

def mul(U , V):
  n = len(U)
  Z = [[0]*n for _ in range(n)]

  for row in range(n):
    for col in range(n):
      e = 0
      for i in range(n):
        e += U[row][i] * V[i][col]
      Z[row][col] = e % 1000
  return Z
  

def square(A, B):
  if B == 1:
    for x in range(n):
      for y in range(n):
        A[x][y] %= 1000
    return A

  temp = square(A, B//2)

  if B%2: #홀수면.
    return mul(mul(temp,temp), A)
  else:
    return mul(temp, temp)

result = square(A,B)
for r in result:
  print(*r)