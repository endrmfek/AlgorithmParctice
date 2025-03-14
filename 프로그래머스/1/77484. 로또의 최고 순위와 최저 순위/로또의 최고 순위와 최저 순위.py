def solution(lottos, win_nums):
    answer = []
    lottos.sort()
    win_nums.sort()
    
    zero = lottos.count(0)
    count = 0
    success = {0:6}
    rank = 6
    for i in range(1,7):
      success[i] = rank
      rank -=1
    
    for num in lottos:
      if num in win_nums:
        count +=1

    min_s = success[count+zero]
    max_s = success[count]

    return [min_s, max_s]