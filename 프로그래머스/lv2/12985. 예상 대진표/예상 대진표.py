def solution(n,a,b):
    answer = 0
    #a가 작은수 b가 큰수
    if a > b:
        a,b = b,a

    while a != b:
        #짝수면 ex) 4
        if a % 2 == 0:
            a = a//2
        else:
            a = (a+1)//2
            
        if b % 2 == 0:
            b = b//2
        else:
            b = (b+1)//2
        answer += 1
        

    return answer