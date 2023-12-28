import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    static int r,c,h;
    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 0, 0, -1, 1};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    static int[][][] map;
    static int[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][r][c];
        visited = new int[h][r][c];
        Queue<int[]> q = new LinkedList<>();

        for(int k=0; k<h; k++) {
            for(int i=0; i<r; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<c; j++) {
                    int data = Integer.parseInt(st.nextToken());
                    map[k][i][j] = data;
                    if(data == 1) {
                        visited[k][i][j] = 1;
                        q.add(new int[]{k ,i, j});
                    }
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
        for(int k=0; k<h; k++) {
            for(int i=0; i<r; i++) {
                for(int j=0; j<c; j++) {
                    if(map[k][i][j] == 0 && visited[k][i][j] == 0) {
                        return -1;
                    } else {
                        maxValue = Math.max(maxValue, visited[k][i][j]);
                    }
                }
            }
        }
        //시작을 1로 했기때문에 -1.
        return maxValue-1;
    }

    static void bfs(Queue<int[]> q) {

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowH = now[0];
            int nowR = now[1];
            int nowC = now[2];

            //이부분이죠.
            for(int i=0; i<6; i++) {
                int nh = nowH + dh[i];
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];

                if(nr < 0 || nr >= r || nc < 0 || nc >= c || nh <0 || nh >= h) {
                    continue;
                }

                if(map[nh][nr][nc] == 0 && visited[nh][nr][nc] == 0) {
                    visited[nh][nr][nc] = visited[nowH][nowR][nowC] + 1;
                    q.add(new int[]{nh, nr, nc});
                }
            }
        }
    }
}
