from collections import Counter

def solution2(k, tangerine):
    answer = 0
    counter = Counter(tangerine)
    count = sorted(counter.values(), reverse=True)
    
    for c in count:
        k -= c
        answer += 1
        if k <= 0:
            break;
            
    return answer


def solution(k, tangerine):
    answer = 0
    count = [0] * max(tangerine)
    
    for t in tangerine:
        count[t-1] += 1
    
    count.sort(reverse=True)
    # print(count)
    
    index = 0
    while answer < k:
        answer += count[index]
        index += 1
        
    return index
    