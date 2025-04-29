
def solution(park, routes):
    dir = {'E': (0, 1), 'W': (0, -1), 'S': (1, 0), 'N': (-1, 0)}
    h, w = len(park), len(park[0])

    # 시작 위치 찾기
    for i, row in enumerate(park):
        if 'S' in row:
            x, y = i, row.index('S')
            break

    # 이동 함수
    def move(route):
        r, s = route.split()
        nx, ny = x, y

        for _ in range(int(s)):
            nx += dir[r][0]
            ny += dir[r][1]
            if not (0 <= nx < h and 0 <= ny < w) or park[nx][ny] == 'X':
                return x, y

        return nx, ny

    for route in routes:
        x, y = move(route)

    return [x, y]