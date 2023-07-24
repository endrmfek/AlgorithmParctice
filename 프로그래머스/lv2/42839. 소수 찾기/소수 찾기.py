from itertools import permutations
def solution(numbers):
    answer = 0
    data = set()
    for i in range(len(numbers)):
        data = data | set(map(int, map("".join, permutations(numbers,i+1))))
    data = data - set(range(0,2))
    
    for num in range(2, int(max(data)**0.5)+1):
        data = data - set(range(num*2, max(data)+1, num))
        
    
    return len(data)