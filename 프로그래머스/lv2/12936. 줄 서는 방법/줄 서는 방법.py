import math
def factorial(n):
    if n == 1:
        return 1
    else:
        return n * factorial(n-1)

def solution(n, k):
    answer = []
    arr = [i for i in range(1,n+1)]
    
    #ex n = 3 일때
    #3 x 2 x 1 -> 3!
    #첫째자리 = 
    while n != 0:
        nextNumCase = math.factorial(n-1)
        now = k // nextNumCase #몫
        k = k % nextNumCase #나머지
        
        if k == 0:
            answer.append(arr.pop(now-1))
        else:
            answer.append(arr.pop(now))
        n-=1
    return answer