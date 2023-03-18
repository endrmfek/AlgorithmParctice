#지금까지 말한수중에 가운데거를 말해야되는데..
#이거 어떻게 해결하나용??
#매번 정렬하면 무조건 탈락함.
#힙에 넣고 빼?
#접근은 좋았다만 아이디어가 부족했음. -> 힙 2개로 해결가능.

import heapq


n = int(input())
answer = []

leftHeap = [] # 중간값보다 작은 최대힙
rightHeap = [] # 중간값보다 큰 최소힙

for i in range(n):
  num = int(input())

  if len(leftHeap) == len(rightHeap): # 짝수일떄?
    # 파이썬 기본이 최소힙이라 최대힙으로만들려고.. 근데 원래값 안넣어주면 마이너스 삽입시 이상생김.
    heapq.heappush(leftHeap , (-num , num))  
  else: #홀수일때
    heapq.heappush(rightHeap, (num, num))

  if rightHeap and leftHeap[0][1] > rightHeap[0][0]: #홀수인데 중간값이 더 크다면
    min_value = heapq.heappop(rightHeap)[0]
    max_value = heapq.heappop(leftHeap)[1]
    heapq.heappush(leftHeap , (-min_value , min_value))
    heapq.heappush(rightHeap , (max_value , max_value))

  answer.append(leftHeap[0][1])
  
for i in answer:
  print(i)