from math import sqrt
def solution(r1, r2):
    answer = 0
    for i in range(1,r1):
        answer += int(sqrt(r2**2 - i**2)) - int(sqrt(r1**2 - i**2)) + (1 if sqrt(r1**2 - i**2) == int(sqrt(r1**2 - i**2)) else 0)
    for i in range(r1,r2):
        answer += int(sqrt(r2**2 - i**2))
    
    answer = answer * 4
    
    # x or y 가 0 일때
    answer += (r2-r1+1) * 4
    return answer