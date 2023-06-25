def solution(s):
    answer = True
    
    stack = []
    for char in s:
        if char == "(":
            stack.append(char)
        else:
            if stack:
                stack.pop()
            else:
                return False

    if stack:
        return False;
    return True