#계단은 한번에 한계단 혹은 두계단씩.
#연속된 세개의 계단은 안된다잉. but 시작점은 계단에 포함 x
#마지막은 무적권밟아라잉
#최대값 구해라잉
import sys
input = sys.stdin.readline

n= int(input())

dp = [0] * (n+1)
data = [0]

for i in range(n):
  data.append(int(input()))

if n == 1:
  print(data[1])

else:
  dp[1] = data[1]
  dp[2] = data[2]+data[1]

  for i in range(3, n+1):
    dp[i] = max(dp[i-3] + data[i-1] + data[i] , dp[i-2] + data[i])
  
  print(dp[n])


