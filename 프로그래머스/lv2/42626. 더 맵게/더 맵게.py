import heapq

def solution(scoville, K):
    answer = 0
    q = []
    
    for s in scoville:
        heapq.heappush(q, s)

    while q[0] < K:
        first = heapq.heappop(q)
        second = heapq.heappop(q)
        
        sc = first + (second * 2)
        heapq.heappush(q, sc)
        answer += 1
        
        if len(q) == 1 and q[0] < K:
            return -1
    return answer

print(solution([1, 2, 3, 9, 10, 12] , 7))