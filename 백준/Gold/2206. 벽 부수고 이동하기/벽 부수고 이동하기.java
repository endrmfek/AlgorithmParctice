import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class Main {

    //최단거리 -> BFS로 풀면돼.
    //벽하나를 부수는 경우 -> 이걸 어떻게 해결할거야?
    //상태를 저장하는 배열 하나를 추가해야될듯?
    static int[][] map;
    static int[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
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
            int nowX = now[1];
            int nowY = now[2];

            for(int i=0; i<4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx >=0 && nx <r && ny >=0 && ny<c) {
                    if(map[nx][ny] == 0) { //갈수 있어?
                        if(visited[isBroken][nx][ny] == 0) { //안가봤으면
                            visited[isBroken][nx][ny] = visited[isBroken][nowX][nowY] + 1;
                            q.add(new int[]{isBroken, nx, ny});
                            if(nx == r-1 && ny == c-1) {
                                return visited[isBroken][nx][ny];
                            }
                        }
                    } else { //갈수 없어?
                        if(isBroken == 0) { //아직 한번도 안부셨을때만 갈 수 있겠지
                            if(visited[1][nx][ny] == 0) {
                                visited[1][nx][ny] = visited[isBroken][nowX][nowY] + 1;
                                q.add(new int[]{1, nx, ny});
                                if(nx == r-1 && ny == c-1) {
                                    return visited[1][nx][ny];
                                }
                            }

                        }

                    }
                }
            }
        }
        return -1;
    }
}
