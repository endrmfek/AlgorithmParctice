from collections import defaultdict



#많이 사용된 알파벳 -> 대문자로 출력해라.

data = input().upper()
result = defaultdict(int)

for i in data:
  result[i] += 1

max_count = max(result.values())

if list(result.values()).count(max_count) > 1:
  print('?')
else:
  idx = list(result.values()).index(max_count)
  items = list(result.keys())
  print(items[idx])