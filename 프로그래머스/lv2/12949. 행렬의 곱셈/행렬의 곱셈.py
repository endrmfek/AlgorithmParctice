def solution(arr1, arr2):
    #A*B B*C -> A*C
    answer = [[0 for _ in range(len(arr2[0]))] for _ in range(len(arr1))]
    
    for A in range(len(arr1)): # A
        for C in range(len(arr2[0])): # C
            for B in range(len(arr1[0])): # B
                answer[A][C] += arr1[A][B] * arr2[B][C]
    return answer