n = input()

# Please write your code here.
digit_sum = sum(int(d) for d in n)

def check(n):
    if int(n)%2==0 and digit_sum % 5 == 0:
        return "Yes"
    else:
        return "No"

print(check(n))