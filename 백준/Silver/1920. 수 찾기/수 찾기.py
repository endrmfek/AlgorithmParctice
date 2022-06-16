def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end)// 2

        if array[mid] == target:
            return mid
        elif array[mid] > target:
            end = mid - 1
        else :
            start = mid + 1
    return None

n = int(input())
data = list(map(int,input().split()))
data.sort()

m = int(input())
targets = list(map(int,input().split()))

for target in targets:
  result = binary_search(data, target, 0, n-1)
  
  if result is not None:
    print(1)
  else:
    print(0)

