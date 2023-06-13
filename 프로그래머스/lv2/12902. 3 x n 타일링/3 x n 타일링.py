#1000000007
def solution(n):
    answer = 0
    dp = [0 for _ in range(5001)]
    if n%2 != 0:
        return 0
    dp[2] = 3
    dp[4] = dp[2]*3 + 2
    dp[6] = dp[4]*3 + 2*dp[2] + 2
    
    for i in range(8, n+1, 2):
        dp[i] = 3*dp[i-2] + 2
        for j in range(i-4, -1,-2):
            dp[i] += dp[j] * 2
        dp[i] = dp[i] % 1000000007
    
    return dp[n]