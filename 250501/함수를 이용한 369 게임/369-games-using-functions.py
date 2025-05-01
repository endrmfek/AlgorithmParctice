a, b = map(int, input().split())

# Please write your code here.
def check_three(n):
    numbers = [num for num in str(n)]
    if any(d in numbers for d in '369'):
        return True
    else:
        return False

result = 0
for num in range(a,b+1):
    if check_three(num) or num % 3 == 0:
        result += 1

print(result)