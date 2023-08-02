class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        #2중 for문으로 풀 수 있겠지 -> 시간초과
        # result = 0
        # for i in range(len(prices)-1):
        #     for j in range(i+1, len(prices)):
        #         result = max(result, prices[j]- prices[i])
        # return result
        
        minV = 100001
        maxV = 0
        
        # 7 1 5 3 6 4 -> 
        for price in prices:
            minV = min(minV, price)
            maxV = max(maxV, price-minV)
            
        return maxV