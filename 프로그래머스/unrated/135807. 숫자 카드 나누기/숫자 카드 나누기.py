from math import gcd

#최대공약수 구하는법 -> 유클리드 

def get_gcd(arr):
    g = arr[0]
    for i in range(1, len(arr)):
        g = gcd(g, arr[i])
    return g

def solution(arrayA, arrayB):
    answer = 0
    #1. 각 배열의 최대 공약수 구해
    gcdA, gcdB = get_gcd(arrayA) , get_gcd(arrayB)
    
    if all(numB % gcdA != 0 for numB in arrayB):
        answer = max(answer, gcdA)
        
    if all(numA % gcdB != 0 for numA in arrayA):
        answer = max(answer, gcdB)
        
    return answer