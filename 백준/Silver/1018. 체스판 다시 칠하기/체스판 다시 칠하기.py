def calc_min(ny, nx):
    global chase1, chase2, board
    cnt1 = cnt2 = 0

    for i in range(8):
        for j in range(8):
            cnt1 += (board[ny+i][nx+j] != chase1[i][j])
            cnt2 += (board[ny+i][nx+j] != chase2[i][j])

    return min(cnt1, cnt2)

chase1 = [['' for _ in range(8)] for _ in range(8)]
chase2 = [['' for _ in range(8)] for _ in range(8)]

for i in range(8):
    for j in range(8):
        chase1[i][j] = 'W' if (i+j) % 2 == 0 else 'B'
        chase2[i][j] = 'B' if (i+j) % 2 == 0 else 'W'

N,M = map(int, input().split())
board = [input() for _ in range(N)]

result = int(1e9)
for y in range(N-7):
    for x in range(M-7):
        result = min(result, calc_min(y,x))

print(result)