n = int(input())

dp = [0] * n
dst = list(map(int,input().split()))
price = list(map(int,input().split()))

std = price[0]
dp[1] = dst[0] * std

for i in range(2, n):
  if std*dst[i-1] > price[i-1]*dst[i-1]:
    std = price[i-1]
    dp[i] = dst[i-1] * std
  else:
    dp[i] = dst[i-1] * std

print(sum(dp))