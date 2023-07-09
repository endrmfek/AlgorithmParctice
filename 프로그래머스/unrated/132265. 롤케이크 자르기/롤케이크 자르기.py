from collections import Counter

def solution(topping):
    answer = 0
    bro = Counter(topping)
    little = set()
    
    for t in topping:
        bro[t] -= 1
        little.add(t)
        
        if bro[t] == 0:
            del bro[t]
            
        if len(bro) == len(little):
            answer+=1
            
    return answer

# 시간초과
def solution_fail(topping):
    answer = 0
    for i in range(1,len(topping)-1):
        little = len(set(topping[:i]))
        bro = len(set(topping[i:]))
        
        if little == bro:
            answer += 1
            
    return answer