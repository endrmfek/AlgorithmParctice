# #dfs. -> 결국 완전탐색
# answer = 0
# def queen(n,x,row):
#     global answer
#     if n == x:
#         answer+=1
#     else:
#          #column에 대해 지금까지 row를 다 뒤져
#         for y in range(n):
#             row[x] = y
#             if check(x, row):
#                 queen(n, x+1,row)
    


# #지금까지 row를 다뒤져봐
# def check(x, row):
    
#     for i in range(x):
#         #column이 같거나 대각선이면 안되지.
#         if row[x] == row[i] or abs(row[x] - row[i]) == abs(x-i):
#             return False;
    
#     return True

# def solution(n):
#     row = [0] * n
#     queen(n,0,row)
#     return answer

answer = 0
def solution(n):
    global answer
    row = [True]*n
    r_dig = [True]*2*n
    l_dig = [True]*2*n
    def queen(r, remain):
        global answer
        if remain:
            for idx,i in enumerate(remain):
                if row[i] and r_dig[r-i] and l_dig[r+i]:
                    next_remain = remain[:idx] + remain[idx+1:]
                    row[i] = r_dig[r-i] = l_dig[r+i] = False
                    queen(r+1, next_remain)
                    row[i] = r_dig[r-i] = l_dig[r+i] = True
        else:
            answer += 1

    queen(0, list(range(n)))

    return answer