def solution(n, left, right):
    answer = []
    for num in range(left, right+1):
        row, col = divmod(num, n)
        answer.append(max(row,col)+1)
    return answer