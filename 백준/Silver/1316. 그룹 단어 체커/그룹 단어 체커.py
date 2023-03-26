#그룹단어 -> 연속되어나와야돼.

num = int(input())
count = 0


for i in range(num):
  word = input()

  for i in range(0, len(word)-1):
    if word[i] == word[i+1]:
      pass

    if word[i] != word[i+1]: # 앞뒤가 틀릴때
      if word[i] in word[i+1:]: # 뒤로 나오면
        count += 1
        break;

print(num-count)