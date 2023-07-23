from collections import deque
from itertools import combinations
def solution1(places):
    #파티션을 신경쓰지말고 BFS로 완전 탐색 갈기자.
    answer = []
    
    for place in places:
        seat = []
        for p in place:
            seat.append(list(p))
        answer.append(check(seat))
    return answer
        
    
def check(data : list):
    #한 반이 있어. -> P위치부터 찾아야지 근데 무조건 5x5야.
    position = []
    for r in range(5):
        for c in range(5):
            if data[r][c] == 'P':
                position.append((r,c))

    #그럼 각 P에 대해 bfs 가자
    q = deque()
    dr = [0,0,1,-1]
    dc = [-1,1,0,0]

    for r, c in position:
        q.append((r,c))
        visited = [[False]* 5 for _ in range(5)]
        distance = [[0]*5 for _ in range(5)]

        while q:
            row,col = q.popleft();
            visited[row][col] = True

            for i in range(4):
                nr = row + dr[i]
                nc = col + dc[i]

                if 0<= nr <5 and 0<= nc <5 and not visited[nr][nc]:

                    if data[nr][nc] == "O":
                        distance[nr][nc] = distance[row][col] + 1
                        q.append((nr,nc))

                    if data[nr][nc] == "P" and distance[row][col] <= 1:
                        return 0
    return 1                

#=============================================================================
def solution(places):
    answer = []
    
    for place in places:
        # 각 반에 대하여
        person = []
        for i, row in enumerate(place):
            for j, col in enumerate(row):
                if place[i][j] == 'P':
                    person.append((i,j))
                    
        check = True
        for p1, p2 in combinations(person, 2):
            p1Row, p1Col, p2Row, p2Col = p1[0], p1[1], p2[0], p2[1]
            if abs(p1Row - p2Row) + abs(p1Col - p2Col) <= 1:
                check = False;
                break;
            
            #같은 X축에 or 같은 Y축에 or 대각선에
            if abs(p1Row - p2Row) + abs(p1Col - p2Col) == 2:
                #같은 Row축에 있을때
                if p1Row == p2Row:
                    if place[p1Row][(p1Col+p2Col)//2] == 'O':
                        check= False;
                        break;
                #같은 Col축에 있을때
                elif p1Col == p2Col:
                    if place[(p1Row+p2Row)//2][p1Col] == 'O':
                        check= False;
                        break;
                #대각선에 있을때
                else:
                    if place[p1Row][p2Col] == 'O' or place[p2Row][p1Col] == 'O':
                        check= False;
                        break;
        if check:
            answer.append(1)
        else:
            answer.append(0)
            
    return answer
                    
            
    

    