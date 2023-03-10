import sys
input= sys.stdin.readline

n = int(input())
data = []
dp = [0]*n

for i in range(n):
    data.append(int(input()))

dp[0] = data[0]
if n > 1:
    dp[1] = data[0]+data[1]

if n > 2:
    dp[2] = max(data[2]+data[1], data[2]+data[0], dp[1])

for i in range(3, n):
    dp[i] = max(dp[i-1], dp[i-3]+data[i-1]+data[i], dp[i-2]+data[i])

print(dp[n-1])