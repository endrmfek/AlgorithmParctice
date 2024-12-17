def solution(s):
    s = s.lower()
    p = 0
    y = 0
    for v in s:
        if v == 'p':
            p += 1
        
        if v == 'y':
            y += 1
    if p == y:
        return True
    else:
        return False
            