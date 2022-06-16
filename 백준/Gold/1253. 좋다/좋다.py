#N개의 수 중에서 어떤수가 다른 수 두개의 합으로 나타낼수 있으면 좋다.

import sys



n = int(input())
data = list(map(int,input().split()))

count = 0

data.sort()

for k in range(n):
  target = data[k]
  # temp = data[:k] + data[k+1:n+1]
  i=0
  j=n-1
  # j=len(temp)-1
  #풀이1
  while(i < j):
    
    if target == data[i] + data[j]:
      #본인은 포함되어있으면 안됩니다. ->조건문으로 제외
      if (i != k and j != k): 
        count+=1
        break;
      elif i==k:
        i+=1
      else:
        j-=1
    elif data[i] + data[j] < target:
      i+=1
    else:
      j-=1

  #풀이2 아싸리 본인을 제외한 리스트를 생성
  # while (i<j):
  #   if target == temp[i]+ temp[j]:
  #     count+=1
  #     break;
  #   else:
  #     if target > temp[i] + temp[j]:
  #       i += 1
  #     else:
  #       j -= 1
  
print(count)
    
