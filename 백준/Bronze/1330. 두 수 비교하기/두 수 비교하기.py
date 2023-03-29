data = input().split(' ')

a = int(data[0])
b = int(data[1])

if a > b:
    print('>')
elif a < b:
    print('<')
else:
    print('==')