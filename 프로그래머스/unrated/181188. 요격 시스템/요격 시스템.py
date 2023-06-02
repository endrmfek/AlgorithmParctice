def solution(targets):
    answer = 0
    temp = 0
    targets.sort(key = lambda x : x[1])
    
    for target in targets:
        if target[0] < temp:
            continue
        else:
            answer += 1
            temp = target[1]
            
    return answer