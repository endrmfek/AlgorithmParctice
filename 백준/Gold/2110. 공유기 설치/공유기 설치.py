n, c = list(map(int, input().split(' ')))

array = []
for _ in range(n):
    array.append(int(input()))
array.sort()

start = 1 #집의 좌표중 가장 작은 값
end = array[-1] - array[0] #집의 좌표중 가장 큰 값
result = 0

while(start <= end):
    mid = (start + end) //2 #가장 인접한 두 공유기 사이의 거리?
    value = array[0]
    count = 1

    for i in range(1, n): #설치를 해보는거야.
        if array[i] >= value + mid:
            value = array[i]
            count += 1

    if count >= c:
        start = mid + 1;
        result = mid
    else:
        end = mid -1 

print(result)
    