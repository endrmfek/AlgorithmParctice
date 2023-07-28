import math
from collections import deque

def solution(progresses , speeds):
    q = deque([math.ceil((100-a) / b) for a,b in zip(progresses, speeds)])
    answer = []
    print(q)
    while q:
        day = q.popleft()
        count = 1
        
        while q and day >= q[0]:
            count += 1
            q.popleft()
            
        answer.append(count)
    
    return answer
  