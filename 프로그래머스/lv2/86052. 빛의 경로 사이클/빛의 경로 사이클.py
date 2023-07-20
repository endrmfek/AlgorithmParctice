def solution(grid):
    answer = []
    
    #이문제의 하이라이트 => 방향을 어떻게 고려할것인지.
    
    #1. 방향설정 -> 아래, 오른, 위, 왼
    dr = (1,0,-1,0)
    dc = (0,1,0,-1)
    
    lr, lc = len(grid) , len(grid[0])
    #row,col,direction을 고려한 3차원 visited 변수 설정
    visited = [[[False for _ in range(4)] for _ in range(lc)] for _ in range(lr)]
    
    #2. 모든 노드와 모든 방향에 대해 탐색을 시작
    for r in range(lr):
        for c in range(lc):
            for d in range(4):
                
                #2-1 우선 여기 지나왔는지 확인
                if visited[r][c][d]:
                    continue
                    
                count = 0
                nr, nc = r, c
                
                #2-2 사이클이 생긴다? -> 동일한 방향으로 동일한 노드에 다시 도착하는 것
                while not visited[nr][nc][d]:
                    visited[nr][nc][d] = True
                    
                    if grid[nr][nc] == 'S': #직진
                        pass
                    elif grid[nr][nc] == 'L': #왼쪽방향
                        d = (d - 1) % 4
                    elif grid[nr][nc] == 'R':
                        d = (d + 1) % 4
                        
                    count += 1
                    nr = (nr + dr[d]) % lr
                    nc = (nc + dc[d]) % lc
                answer.append(count)
    
    return sorted(answer)

    