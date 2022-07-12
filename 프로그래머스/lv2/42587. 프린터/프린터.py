def solution(priorities, location):
    answer = 0
    
    data = []
    for idx, priority in enumerate(priorities):
      data.append(( priority , idx ))

    
    while data:
      temp = data.pop(0)
      
      flag = False
      for i in data: # 뺄수 없는 경우
        if temp[0] < i[0]:
          data.append(temp)
          flag = True
          break;

      #뺄수 없는 경우
      if (flag):
        continue
      else:
        answer += 1
        if temp[1] == location:
          break;
      
    return answer