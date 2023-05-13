#최빈값 구하는 법 다시 공부해.
#Counter 쓰는 법, 파이썬 dict 공부!

import sys
from collections import Counter
input = sys.stdin.readline

n = int(input())
data = []

for _ in range(n):
  data.append(int(input()))

data.sort()
#산술평균
print(round(sum(data) / n))

#중앙값
print(data[len(data)//2])

#최빈값
cnt = Counter(data).most_common()
if len(cnt) > 1 and cnt[0][1] == cnt[1][1]:
  print(cnt[1][0])
else:
  print(cnt[0][0])

#범위
print(max(data) - min(data))