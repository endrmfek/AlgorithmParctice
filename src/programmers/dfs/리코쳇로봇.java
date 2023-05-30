package programmers.dfs;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {
    //장애물을 만나거나 맨 끝에 부딪힐 때까지 미끄러져 이동하는게 1.

    static int n, m, startX, startY, endX, endY;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        for(int i=0; i<n; i++) {
            map[i] = board[i].toCharArray();
            for(int j=0; i<m; j++) {
                if(map[i][j] == 'R') {
                    startX = i;
                    startY = j;
                } else if (map[i][j] =='G') {
                    endX = i;
                    endY = j;
                }
            }
        }

        return bfs();
    }

    public static int bfs() {
        //bfs -> Queue 사용.
        //1. Queue생성 , 시작점 add, 시작점 visit
        Queue<int[]> q = new LinkedList<>();
        visited[startX][startY] = true;
        q.add(new int[]{startX, startY, 0});

        while(!q.isEmpty()) {
            int[] point = q.poll();

            int x = point[0];
            int y = point[1];
            int dist = point[2];

            if(x == endX && y == endY) {
                return dist;
            }

            for(int i=0; i<4; i++) {
                int nextX = x;
                int nextY = y;

                //미끄러져 간다.
                for(int k=1; k<Math.max(n,m); k++) {
                    nextX += dx[i];
                    nextY += dy[i];

                    //벽만나거나 장애물 만나면
                    if(nextX <0 || nextX >= n || nextY <0 || nextY >=m || map[nextX][nextY] == 'D') {
                        //한 칸 뒤에서 시작해야돼
                        nextX -= dx[i];
                        nextY -= dy[i];
                        break;
                    }
                }

                if(visited[nextX][nextY]) continue;

                visited[nextX][nextY] = true;
                q.add(new int[] {nextX, nextY, dist+1});
            }

        }

        return -1;
    }

}
