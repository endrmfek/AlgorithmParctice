def solution(s):
    answer = ''
    result = list(map(int, s.split(" ")))
    a,b = str(max(result)), str(min(result))
    return b + " " + a