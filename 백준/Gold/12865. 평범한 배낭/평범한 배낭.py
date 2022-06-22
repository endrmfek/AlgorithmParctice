#무게당 가치의 최대값.
#이거 DP같은걸로 풀어야될거같은데? -> 접근은 좋았지만 방법을 모르쥬 
#dp 다시공부!

n, k = map(int, input().split())
stuff = [[0,0]]
knapsack = [[0 for _ in range(k+1)] for _ in range(n+1)]

for _ in range(n):
  stuff.append(list(map(int,input().split())))

for i in range(1, n+1):
  for j in range(1, k+1):
    w, v = stuff[i][0] , stuff[i][1] # 무게 , 가치
    
    if j < w: #무게가 더 크면
      knapsack[i][j] = knapsack[i-1][j] # 전에거 그냥 가져와
    else: # 무게가 작으면
      knapsack[i][j] = max(v + knapsack[i-1][j-w] , knapsack[i-1][j]) #이전거 그냥 가져오던지, 전거에서 무게 남는거 가져와서 현재무게 더하던지.

print(knapsack[n][k])