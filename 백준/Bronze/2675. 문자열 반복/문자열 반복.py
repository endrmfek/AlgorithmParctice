# s를 입력 -> r번 반복 -> 새 문자열 p

tc = int(input())
result = ""
for i in range(tc):
  repeat , st = input().split()

  for j in st:
    result += j*int(repeat)

  print(result)
  result =""