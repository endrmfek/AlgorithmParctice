import sys
input = sys.stdin.readline

def fibo(n):
  zero = [1,0]
  one = [0,1]

  if n <= 1:
    return

  for i in range(2, n+1):
    zero.append(zero[i-1] + zero[i-2])
    one.append(one[i-1] + one[i-2])

  return zero , one

n = int(input())
zero, one = fibo(40)

for _ in range(n):
  m = int(input())
  print(f'{zero[m]} {one[m]}')