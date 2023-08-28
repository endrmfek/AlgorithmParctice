class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        INF = int(1e9)
        dp = [INF] * (amount+1)
        dp[0] = 0
        for coin in coins:
            
            if coin > amount:
                continue
                
            for i in range(coin, amount+1):
                dp[i] = min(dp[i-coin]+1, dp[i])
                
        if dp[amount] == INF:
            return -1
        else:
            return dp[amount]