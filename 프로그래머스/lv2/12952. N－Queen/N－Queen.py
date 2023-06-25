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

ans = 0
num = 0
chkX = [False for i in range(32)]
chkCross1 = [False for i in range(32)]
chkCross2 = [False for i in range(32)]

def nq(y,n):
    global ans
    x = 0
    if y > n:
        ans+=1
        return
    
    for x in range(1, n+1):
        if chkX[x] or chkCross1[y+x] or chkCross2[(y-x) + n]:
            continue
        chkX[x] = True
        chkCross1[y+x] = True
        chkCross2[(y-x) + n] = True
        
        nq(y+1, n)
        
        chkX[x] = False
        chkCross1[y+x] = False
        chkCross2[(y-x) + n] = False

def solution(n):
    nq(1,n)
    return ans

