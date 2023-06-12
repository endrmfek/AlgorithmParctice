#1,000,000,007
def solution(n):
    answer = 0
    dp = [0 for _ in range(n+1)]
    dp[1] = 1
    dp[2] = 2
    dp[3] = 3
    
    for i in range(4, n+1):
        dp[i] = (dp[i-2] + dp[i-1]) % 1000000007
                            
    return dp[n]