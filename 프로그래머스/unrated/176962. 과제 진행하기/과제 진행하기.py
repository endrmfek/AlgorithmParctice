#name은 알파벳 소문자로만 이루어져 있습니다. 중복 X
#start : 과제의 시작 시각을 나타냅니다. "hh:mm" 겹치지 X
#playtime :과제를 마치는데 걸린 시간
#배열은 시간순으로 정렬되어 있지 않을 수 있습니다.
#진행중이던 과제가 끝나는 시각과 새로운 과제를 시작해야하는 시각이 같은 경우 진행중이던 과제는 끝난 것으로 판단합니다.
from collections import deque

def change(time):
    yy, mm = map(int, time.split(":"))
    return yy*60 + mm

def solution(plans):
    answer = []
    
    plans = [(name, change(start), int(playtime)) for name, start, playtime in plans]
    plans = sorted(plans, key = lambda x : x[1])
    
    stack = []
    left_time = 0
    
    for i in range(len(plans)):
        name, start, playtime = plans[i]
        
        while stack:
            _name, _playtime = stack.pop()
            if left_time >= _playtime:
                left_time -= _playtime
                answer.append(_name)
            else:
                stack.append([_name, _playtime-left_time])
                break
            
        stack.append([name, playtime])
        
        if i < len(plans)-1:
            next_start = plans[i+1][1]
            left_time = next_start - start
            
    while stack:
        _name, _ = stack.pop()
        answer.append(_name)
        
    return answer