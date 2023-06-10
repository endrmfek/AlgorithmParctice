def solution(s : list):
    stack = []
    
    for char in s:
        if not stack:
            stack.append(char)
        else:
            if stack[-1] == char:
                stack.pop(-1)
            else:
                stack.append(char)
    if stack:
        return 0
    else:
        return 1