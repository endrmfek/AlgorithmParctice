#n.sort() , sorted(n) 차이
#sort()는 n 그자체를 정렬한다. 그리고 int값만 가능.
#but sorted(n)은 n을 정렬한 값을 반환하고 str도 정렬이 가능.
import sys

input = sys.stdin.readline
n=input()

n = sorted(n,reverse=True)

x = int("".join(n))

print(x)