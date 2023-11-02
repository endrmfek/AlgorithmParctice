n = int(input())
arr = set(map(int, input().split()))
m = int(input())
data = list(map(int,input().split()))

for num in data:
    if num in arr:
        print(1)
    else:
        print(0)