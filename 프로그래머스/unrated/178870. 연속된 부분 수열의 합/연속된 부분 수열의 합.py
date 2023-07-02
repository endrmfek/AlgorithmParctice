def solution(sequence, k):
    answer = []
    total, end = 0,0
    
    for i in range(len(sequence)):
        while total < k and end < len(sequence):
            total += sequence[end]
            end+=1
        
        #합이 커졌거나 end가 범위를 벗어났거나
        if total == k:
            answer.append([i, end-1])
        
        #start (i) 를 땡겨와서 다시 계산
        total -= sequence[i]
    
    answer.sort(key = lambda x : (x[1]-x[0]))
    return answer[0]