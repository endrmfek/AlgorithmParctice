from collections import deque

#길이가 같은 두 개의 큐

def solution(queue1, queue2):
    q1, q2 = deque(queue1), deque(queue2)
    sum1, sum2 = sum(queue1), sum(queue2)
    
    if (sum1 + sum2) % 2 != 0:
        return -1
    
    target = (sum1 + sum2) // 2
    cnt = 0
    
    while cnt < len(queue1) * 3:
        
        if sum1 > target:
            num = q1.popleft()
            sum1 -= num
            sum2 += num
            q2.append(num)
            cnt +=1
        elif sum2 > target:
            num = q2.popleft()
            sum1 += num
            sum2 -= num
            q1.append(num)
            cnt +=1
        
        if sum1 == sum2:
            return cnt
            
        
    return -1