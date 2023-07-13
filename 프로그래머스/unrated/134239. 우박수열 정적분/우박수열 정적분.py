def collazt(k):
    arr = []
    while k != 1:
        arr.append(k)
        k = k//2 if k % 2 == 0 else (k*3)+1
    arr.append(k)
    return arr

def solution(k, ranges):
    #짝수라면 2로 나눠
    #홀수라면 3을 곱하고 1을 더해
    answer = []
    arr = collazt(k)
    
    for start, offset in ranges:
        total = 0
        temp = arr[start:len(arr)+offset]
        if start >= offset+len(arr):
            answer.append(-1)
            continue
        for i in range(len(temp)-1):
            total += ((temp[i]+temp[i+1])/2)
        answer.append(total)
        
    return answer