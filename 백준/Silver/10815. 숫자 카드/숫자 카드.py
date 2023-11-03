n = int(input())
my_card = set(map(int, input().split()))

m = int(input())

check_card = list(map(int, input().split()))

for num in check_card:
  if num in my_card:
    print(1)
  else:
    print(0)


