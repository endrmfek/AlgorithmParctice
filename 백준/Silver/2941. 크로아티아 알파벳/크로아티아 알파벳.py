data = ["c=" , "c-", "dz=", "d-", "lj", "nj", "s=", "z="]

word = input()
# 어떻게 접근할까요

for i in data:
  word = word.replace(i,'*')

print(len(word))