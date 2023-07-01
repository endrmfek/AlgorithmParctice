def solution(sequence, k):
    answer = []
    n = len(sequence)
    left = 0
    right = -1
    hap = 0
    while True:
        # 현재까지 합보다 K가 크면
        if hap < k:
            right += 1
            if right >= n:
                break
            hap += sequence[right]
        else:    
            hap -= sequence[left]
            left += 1
            if left >= n:
                break
                
        if hap == k:
            answer.append([left,right])
            
    answer.sort(key = lambda x : (x[1]-x[0], x[0]))
    return answer[0]