from collections import deque

def solution(places):
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
                
            
    