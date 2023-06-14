def solution(board):
    answer = 0

    row = len(board)
    col = len(board[0])
    
    dp = [[0]*col for _ in range(row)]
    dp[0] = board[0]
    
    for r in range(row):
        dp[r][0] = board[r][0]
        
    for x in range(1, row):
        for y in range(1, col):
            if board[x][y] == 1:
                dp[x][y] = min(dp[x-1][y], dp[x-1][y-1], dp[x][y-1]) + 1
    
    for r in range(row):
        temp = max(dp[r])
        answer = max(answer, temp)

    return answer ** 2