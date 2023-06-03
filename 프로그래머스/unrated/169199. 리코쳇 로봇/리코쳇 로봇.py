def solution(board):
    answer = 0
    #bfs로 푼다.
    q = []
    for x, row in enumerate(board):
        for y, col in enumerate(row):
            if board[x][y] == 'R':
                q.append((x,y,0))
                
    visited = set()
    
    while(q):
        x,y,length = q.pop(0)
        
        if (x,y) in visited:
            continue
        if board[x][y] == 'G':
            return length;
        
        visited.add((x,y))
        
        for dx, dy in ((0,1), (0,-1), (1,0), (-1,0)):
            nowX, nowY = x, y
            while True:
                nx = nowX + dx
                ny = nowY + dy
                if 0<= nx < len(board) and 0<=ny < len(board[0]) and board[nx][ny] !='D':
                    nowX , nowY = nx, ny
                    continue
                q.append((nowX, nowY, length+1))
                break;
    
    return -1