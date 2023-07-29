from collections import deque

def solution(prices):
    result = [0] * len(prices)
    
    for i in range(0, len(prices)-1):
        for j in range(i+1, len(prices)):
            result[i] += 1
            if prices[i] > prices[j]:
                break;
    return result

        
def solution2(prices):
    answer = []
    q = deque(prices)
    
    while q:
        price = q.popleft()
        sec = 0
        
        for value in q:
            sec += 1
            if price > value:
                break;
        
        answer.append(sec)
    
    return answer