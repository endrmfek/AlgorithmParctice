#거꾸로충임 개수비교해라.

a ,b = input().split()
reverse_a = a[::-1]
reverse_b = b[::-1]

result = max(reverse_a, reverse_b)
print(result)