import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    static int r,c;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {-1, 1, 0, 0};
    static int[][] map;
    static int[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new int[r][c];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<c; j++) {
                int data = Integer.parseInt(st.nextToken());
                map[i][j] = data;
                if(data == 1) {
                    visited[i][j] = 1;
                    q.add(new int[]{i, j});
                }
            }
        }

        bfs(q);
        int result = check();

        if(result == -1) {
            System.out.println(-1);
        }else {
            System.out.println(result);
        }

    }

    private static int check() {
        int maxValue = 0;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(map[i][j] == 0 && visited[i][j] == 0) {
                    return -1;
                } else {
                    maxValue = Math.max(maxValue, visited[i][j]);
                }
            }
        }
        //시작을 1로 했기때문에 -1.
        return maxValue-1;
    }

    static void bfs(Queue<int[]> q) {

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowR = now[0];
            int nowC = now[1];

            for(int i=0; i<4; i++) {
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];

                if(nr < 0 || nr >= r || nc < 0 || nc >= c) {
                    continue;
                }

                if(map[nr][nc] == 0 && visited[nr][nc] == 0) {
                    visited[nr][nc] = visited[nowR][nowC] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }
}
