from collections import Counter
def solution(want, number, discount):
    answer = 0
    dic = {}
    for i in range(len(want)):
        dic[want[i]] = number[i]
        
    n = sum(number)
    
    for i in range(len(discount)-n+1):
        if dic == Counter(discount[i:i+n]):
            answer+=1
    
    return answer