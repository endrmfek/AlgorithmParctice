def solution(elements):
    answer = 0
    arr = elements * 2
    result = set()
        
    for size in range(1,len(elements)+1):
        for i in range(len(elements)):
            result.add(sum(arr[i:i+size]))
    return len(result)

