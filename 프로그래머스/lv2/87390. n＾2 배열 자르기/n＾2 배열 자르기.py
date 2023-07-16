def solution(n, left, right):
    answer = []
    for num in range(left, right+1):
        answer.append(max(num//n, num%n)+1)
    return answer