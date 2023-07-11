def solution(elements):
    n = len(elements)
    result = set()
    
    #각 숫자에서
    for i in range(n):
        _sum = elements[i]
        result.add(_sum)
        #n까지 더할때마다 set에 넣어. 
        for size in range(i+1, i+n):
            _sum += elements[size%n]
            result.add(_sum)
    
    return len(result)

            


# O(n^3)
def solution1(elements):
    answer = 0
    arr = elements * 2
    result = set()
        
    for size in range(1,len(elements)+1):
        for i in range(len(elements)):
            result.add(sum(arr[i:i+size]))
    return len(result)

