def solution(priorities, location):
    answer = 0
    data = []
    for i, p in enumerate(priorities):
        data.append((p,i))
        
    while data:
        temp = data.pop(0)
        
        #data에 더 큰거 있으면 (뺄수없는 경우)
        flag = False
        for d in data:
            if temp[0] < d[0]:
                flag = True
                data.append(temp)
                break
                
        if(flag):
            continue
        else: # 뺄수 있는경우
            answer += 1
            if temp[1] == location:
                break;
    return answer

