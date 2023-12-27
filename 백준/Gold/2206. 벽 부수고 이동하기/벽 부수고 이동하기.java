import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    //최단거리 -> BFS로 풀면돼.
    //벽하나를 부수는 경우 -> 이걸 어떻게 해결할거야?
    //상태를 저장하는 배열 하나를 추가해야될듯?
    static int[][] map;
    static int[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int r,c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new int[2][r][c];

        for(int i=0; i<r; i++) {
            String row = br.readLine();
            for(int j=0; j<c; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        if (r == 1 && c == 1) {
            System.out.println(1);
            exit(0);
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0});
        visited[0][0][0] = 1;

        //다른건 벽부수는거 하나잖아.
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int isBroken = now[0];
            int nowR = now[1];
            int nowC = now[2];

            for(int i=0; i<4; i++) {
                int nr = nowR + dr[i];
                int nc = nowC + dc[i];

                if (0 <= nr && nr <r && 0 <= nc && nc <c) {
                    if(map[nr][nc] == 0) { //갈수 있어?
                        if(visited[isBroken][nr][nc] == 0) { //안가봤으면
                            visited[isBroken][nr][nc] = visited[isBroken][nowR][nowC] + 1;
                            q.add(new int[]{isBroken, nr, nc});
                            if(nr == r-1 && nc == c-1) {
                                return visited[isBroken][nr][nc];
                            }
                        }
                    } else { //갈수 없어?
                        if(isBroken == 0) { //아직 한번도 안부셨을때만 갈 수 있겠지
                            if(visited[1][nr][nc] == 0) {
                                visited[1][nr][nc] = visited[isBroken][nowR][nowC] + 1;
                                q.add(new int[]{1, nr, nc});
                                if(nr == r-1 && nc == c-1) {
                                    return visited[1][nr][nc];
                                }
                            }
                        }
                    }
                }
            }
        }
        //r-1, c-1 까지 못가면
        return -1;
    }
}
